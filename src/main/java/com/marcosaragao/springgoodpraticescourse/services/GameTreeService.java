package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.*;
import com.marcosaragao.springgoodpraticescourse.dto.GameTreeCreateDTO;
import com.marcosaragao.springgoodpraticescourse.dto.PlayStepDTO;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatantRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRoundRepository;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.GameTreeException;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GameTreeService {

    @Autowired
    private GameTreeRepository gameTreeRepository;

    @Autowired
    private GameTreeCombatantRepository gameTreeCombatantRepository;

    @Autowired
    private GameTreeCombatRepository gameTreeCombatRepository;

    @Autowired
    private GameTreeRoundRepository gameTreeRoundRepository;

    public GameTree find(Integer id){
        Optional<GameTree> obj = gameTreeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado. Id:" + id.toString()));
    }

    @Transactional
    public GameTree playStep(PlayStepDTO playStepDTO){
        if (playStepDTO.getGameTreeId() == null)
            return null;
        Optional<GameTree> gameTreeOptional = gameTreeRepository.findById(playStepDTO.getGameTreeId());
        GameTree gameTree = gameTreeOptional.get();

        GameTreeRound gameTreeRound = gameTree.getRounds().get(gameTree.getCurrentRound());
        GameTreeCombat gameTreeCombat = gameTreeRound.getCombats().get(gameTreeRound.getCurrentCombat());

        setWinner(playStepDTO, gameTreeCombat);
        prepareNextStep(gameTree, gameTreeRound, gameTreeCombat);

        return gameTreeRepository.save(gameTree);
    }

    private void setWinner(PlayStepDTO playStepDTO, GameTreeCombat gameTreeCombat) {

        GameTreeCombatant winnerCombatant = gameTreeCombatantRepository.getOne(playStepDTO.getWinnerId());

        if(gameTreeCombat.getCombatant1().getId().equals(winnerCombatant.getId())){
            gameTreeCombat.setWinner(GameTreeWinnerEnum.COMBATANT1);
        }
        else if(gameTreeCombat.getCombatant2().getId().equals(winnerCombatant.getId())){
            gameTreeCombat.setWinner(GameTreeWinnerEnum.COMBATANT2);
        }
        else{
            throw new GameTreeException("Combatente " + winnerCombatant.getId() + " - " + winnerCombatant.getName() +
                    " nao corresponde aos combatentes do combate atual: " +
                    gameTreeCombat.getCombatant1().getId() + "-" + gameTreeCombat.getCombatant1().getName() + " x " +
                    gameTreeCombat.getCombatant2().getId() + "-" + gameTreeCombat.getCombatant2().getName());
        }
        gameTreeCombatRepository.save(gameTreeCombat);
    }

    private void prepareNextStep(GameTree gameTree, GameTreeRound gameTreeRound, GameTreeCombat gameTreeCombat) {
        Integer roundsTotal = gameTree.getRounds().size();

        // Quantidade de combates do round atual
        Double quantidadeCombates =  Math.pow(2, (roundsTotal - gameTree.getCurrentRound())-1);

        // Ultimo round da partida - Setar vencedor
        if(quantidadeCombates == 1){
            if(gameTreeCombat.getWinner() == GameTreeWinnerEnum.COMBATANT1)
                gameTree.setWinner(gameTreeCombat.getCombatant1());
            else if(gameTreeCombat.getWinner() == GameTreeWinnerEnum.COMBATANT2)
                gameTree.setWinner(gameTreeCombat.getCombatant2());
            return;
        }

        // Caso o combate atual seja o ultimo de um round deve-se criar o proximo round
        if(quantidadeCombates.compareTo(gameTreeRound.getCurrentCombat().doubleValue()+1) == 0){
            gameTree.setCurrentRound(gameTree.getCurrentRound() + 1);
            GameTreeRound newRound = gameTree.getRounds().get(gameTree.getCurrentRound());

            createNextRound(gameTreeRound, newRound);
        }
        else{
            gameTreeRound.setCurrentCombat(gameTreeRound.getCurrentCombat()+1);
            gameTreeRoundRepository.save(gameTreeRound);
        }
    }

    private void createNextRound(GameTreeRound gameTreeRound, GameTreeRound newRound) {

        int indiceListaCombats = 0;
        for(GameTreeCombat newRoundCombat : gameTreeRound.getCombats()){

            // Monta cada novo combate a partir dos combates pares para o 1º combatente
            if(indiceListaCombats % 2 == 0){
                GameTreeCombat newCombat = new GameTreeCombat();

                newCombat.setWinner(GameTreeWinnerEnum.WAITING);
                newCombat.setRound(newRound);

                // Setar combatente 1 a partir do combate par atual
                if(newRoundCombat.getWinner() == GameTreeWinnerEnum.COMBATANT1)
                    newCombat.setCombatant1(newRoundCombat.getCombatant1());
                else if(newRoundCombat.getWinner() == GameTreeWinnerEnum.COMBATANT2)
                    newCombat.setCombatant1(newRoundCombat.getCombatant2());

                // Setar combatente 2 a partir do combate impar
                GameTreeCombat secondCombat = gameTreeRound.getCombats().get(indiceListaCombats+1);
                if(secondCombat.getWinner() == GameTreeWinnerEnum.COMBATANT1)
                    newCombat.setCombatant2(secondCombat.getCombatant1());
                else if(secondCombat.getWinner() == GameTreeWinnerEnum.COMBATANT2)
                    newCombat.setCombatant2(secondCombat.getCombatant2());

                gameTreeCombatRepository.save(newCombat);
            }

            indiceListaCombats++;
        }
    }

    @Transactional
    public GameTree createGame(GameTreeCreateDTO gameTreeCreateDTO) {

        GameTree gameTree = new GameTree(0, null);
        List<GameTreeRound> rounds = new ArrayList<>();

        //Cria os rounds
        Double quantidadeRounds = Math.sqrt(gameTreeCreateDTO.getCombatants().size());
        for(int i = 0 ; i < quantidadeRounds ; i++){
            GameTreeRound gameTreeRound = new GameTreeRound(0, gameTree);
            rounds.add(gameTreeRound);
        }

        //Cria os combatentes, os combates e seta no primeiro round
        int indiceListaCombatentes = 0;
        for(String combatant : gameTreeCreateDTO.getCombatants()){
            // Monta cada novo combate a partir dos combates pares. Ignora os combates impares
            if(indiceListaCombatentes % 2 == 0) {
                GameTreeCombatant gameTreeCombatant1 = new GameTreeCombatant(combatant);
                GameTreeCombatant gameTreeCombatant2 = new GameTreeCombatant(
                        gameTreeCreateDTO.getCombatants().get(indiceListaCombatentes+1));

                GameTreeCombat gameTreeCombat = new GameTreeCombat(gameTreeCombatant1, gameTreeCombatant2, rounds.get(0));
                rounds.get(0).getCombats().add(gameTreeCombat);

                gameTreeCombatantRepository.saveAll(Arrays.asList(gameTreeCombatant1, gameTreeCombatant2));
                gameTreeCombatRepository.save(gameTreeCombat);
            }
            indiceListaCombatentes++;
        }

        gameTree.setRounds(rounds);
        gameTreeRoundRepository.saveAll(rounds);
        return gameTreeRepository.save(gameTree);
    }
}

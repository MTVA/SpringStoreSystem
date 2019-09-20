package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombat;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombatant;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeRound;
import com.marcosaragao.springgoodpraticescourse.domain.old.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.old.Produto;
import com.marcosaragao.springgoodpraticescourse.dto.CategoriaDTO;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatantRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRoundRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.ProdutoRepository;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public void populateDataBase(){

        GameTreeCombatant gameTreeCombatant1 = new GameTreeCombatant("Inception");
        GameTreeCombatant gameTreeCombatant2 = new GameTreeCombatant("Interstellar");

        GameTree gameTree = new GameTree(0, null);

        GameTreeRound gameTreeRound = new GameTreeRound(0, gameTree);

        GameTreeCombat gameTreeCombat = new GameTreeCombat(gameTreeCombatant1, gameTreeCombatant2, gameTreeRound);


        gameTreeCombatantRepository.saveAll(Arrays.asList(gameTreeCombatant1, gameTreeCombatant2));
        gameTreeRepository.save(gameTree);
        gameTreeRoundRepository.save(gameTreeRound);
        gameTreeCombatRepository.save(gameTreeCombat);
    }
}

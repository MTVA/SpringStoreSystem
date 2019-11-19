package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.*;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatantRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRoundRepository;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public GameTree playStep(GameTreeWinnerEnum winner){
        //Optional<GameTree> gameTreeOptional = gameTreeRepository.findById(gameTreeId);
        //GameTree gameTree = gameTreeOptional.get();
        //if (gameTreeId == null)
            return null;

    }

}

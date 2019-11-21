package com.marcosaragao.springgoodpraticescourse.dto;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class GameTreeCreateDTO {

    @Getter
    @Setter
    private Integer creatorId;

    @Getter
    @Setter
    private Integer playerId;

    @Getter
    @Setter
    private List<String> combatants = new ArrayList<>();

    private GameTree toGameTree(GameTreeCreateDTO gameTreeCreateDTO){
        GameTree gameTree = new GameTree();

        gameTree.setWinner(null);
        gameTree.setCurrentRound(0);

        return gameTree;
    }
}

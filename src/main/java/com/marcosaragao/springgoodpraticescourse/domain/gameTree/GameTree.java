package com.marcosaragao.springgoodpraticescourse.domain.gameTree;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.marcosaragao.springgoodpraticescourse.domain.general.Game;
import com.marcosaragao.springgoodpraticescourse.domain.general.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GameTree extends Game {

    @Getter
    @Setter
    private Integer currentRound;

    @Getter
    @Setter
    private GameTreeCombatant winner;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(mappedBy = "gameTree", cascade = CascadeType.ALL)
    private List<GameTreeRound> rounds = new ArrayList<>();



    public GameTree() {
    }

    public GameTree(Integer currentRound, GameTreeCombatant winner) {
        this.currentRound = currentRound;
        this.winner = winner;
    }

    public GameTree(Person creator, Person player, Integer currentRound, GameTreeCombatant winner) {
        super(creator, player);
        this.currentRound = currentRound;
        this.winner = winner;
    }
}

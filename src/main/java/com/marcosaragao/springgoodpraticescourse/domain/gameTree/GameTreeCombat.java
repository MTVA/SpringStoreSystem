package com.marcosaragao.springgoodpraticescourse.domain.gameTree;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GameTreeCombat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private GameTreeWinnerEnum winner;

    @Getter
    @Setter
    private GameTreeCombatant combatant1;

    @Getter
    @Setter
    private GameTreeCombatant combatant2;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "gameTree_id")
    private GameTreeRound round;

    public GameTreeCombat() {
    }

    public GameTreeCombat(GameTreeCombatant combatant1, GameTreeCombatant combatant2, GameTreeRound round) {
        this.combatant1 = combatant1;
        this.combatant2 = combatant2;
        this.winner = GameTreeWinnerEnum.WAITING;
        this.round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTreeCombat categoria = (GameTreeCombat) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

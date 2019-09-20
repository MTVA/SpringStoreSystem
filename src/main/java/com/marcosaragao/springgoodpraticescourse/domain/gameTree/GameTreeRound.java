package com.marcosaragao.springgoodpraticescourse.domain.gameTree;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GameTreeRound implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private Integer currentCombat;

    @Getter
    @Setter
    @OneToMany(mappedBy = "round")
    private List<GameTreeCombat> combats = new ArrayList<>();

    @Getter
    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "gameTree_id")
    private GameTree gameTree;

    public GameTreeRound() {
    }

    public GameTreeRound(Integer currentCombat, GameTree gameTree) {
        this.currentCombat = currentCombat;
        this.gameTree = gameTree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTreeRound categoria = (GameTreeRound) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

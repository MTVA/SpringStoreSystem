package com.marcosaragao.springgoodpraticescourse.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GameTreeCombatantDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Integer combatantId;

    @Getter
    @Setter
    private String name;

    public GameTreeCombatantDTO() {
    }

    public GameTreeCombatantDTO(String name) {
        this.name = name;
    }
}

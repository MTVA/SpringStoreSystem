package com.marcosaragao.springgoodpraticescourse.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade(){

    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
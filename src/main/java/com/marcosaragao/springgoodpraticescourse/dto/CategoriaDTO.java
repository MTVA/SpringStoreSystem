package com.marcosaragao.springgoodpraticescourse.dto;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

public class CategoriaDTO {

    @Getter
    @Setter
    private Integer id;

    @Size(min=2)
    @Getter
    @Setter
    private String nome;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO() {
    }
}

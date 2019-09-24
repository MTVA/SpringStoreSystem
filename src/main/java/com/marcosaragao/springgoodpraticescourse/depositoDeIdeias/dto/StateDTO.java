package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * DTO para State
 */
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateDTO implements Serializable {

    /**
     * Id do Estado
     */
    @Getter
    @Setter
    private String id;

    /**
     * Nome do Estado
     */
    @Getter
    @Setter
    private String nome;

    /**
     * Sigla do Estado
     */
    @Getter
    @Setter
    private String sigla;

}

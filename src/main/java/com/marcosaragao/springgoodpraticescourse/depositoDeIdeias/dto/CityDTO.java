package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * DTO para Cidade
 */
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDTO implements Serializable {

    /**
     * Id da Cidade
     */
    @Getter
    @Setter
    private String id;

    /**
     * Nome da Cidade
     */
    @Getter
    @Setter
    private String nome;


}

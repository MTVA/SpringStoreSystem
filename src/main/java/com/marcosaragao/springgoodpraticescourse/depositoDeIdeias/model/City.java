package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Marcos Aragao on 23/09/19.
 */
@Entity(name = "city")
public class City implements Serializable {

    /**
     * Id
     */
    @Id
    @Getter
    @Setter
    //@SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence")
    //@GeneratedValue(generator = "city_sequence")
    private Long id;

    /**
     * Nome da Cidade
     */
    @Getter
    @Setter
    private String name;

    /**
     * Estado
     */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "stateid")
    private State state;
}

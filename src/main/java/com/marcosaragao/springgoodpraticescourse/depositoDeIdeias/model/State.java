package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Marcos Aragao on 23/09/19.
 */
@Entity(name = "state")
public class State implements Serializable {

    /**
     * Id
     */
    @Id
    @Getter
    @Setter
    //@SequenceGenerator(name = "state_sequence", sequenceName = "state_sequence")
    //@GeneratedValue(generator = "state_sequence")
    @Column(name = "id")
    private Long id;

    /**
     * Nome do Estado
     */
    @Getter
    @Setter
    private String name;

    /**
     * Sigla do Estado
     */
    @Getter
    @Setter
    private String uf;
}

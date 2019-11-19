package com.marcosaragao.springgoodpraticescourse.enums;

import lombok.Getter;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    @Getter
    private int cod;

    @Getter
    private String descricao;

    private TipoCliente(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer cod){

        if (cod == null)
            return null;
        for(TipoCliente tipoCliente : TipoCliente.values() ){
            if(cod.equals(tipoCliente.getCod()))
                return tipoCliente;
        }
        throw new IllegalArgumentException("Codigo invalido para TipoCliente: " + cod);
    }
}

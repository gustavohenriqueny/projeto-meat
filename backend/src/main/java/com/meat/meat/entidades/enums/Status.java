package com.meat.meat.entidades.enums;

import lombok.Getter;

@Getter
public enum Status {

    ATIVO("A", "Ativo"),
    INATIVO("I", "Inativo");

    private final String sigla;
    private final String descricao;

    Status(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

}

package com.meat.meat.entidades.enums;

import lombok.Getter;

@Getter
public enum Permissao {

    ADMINISTRADOR("A","Administrador"),
    USUARIO("U","Usuário");

    private final String sigla;
    private final String valor;

    Permissao(String sigla, String valor) {
        this.sigla = sigla;
        this.valor = valor;
    }
}

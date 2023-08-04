package com.meat.meat.servicos.jwt;

public interface JwtServico {

    String extrairUsuario(String token);

    Boolean isTokenValido(String token, String email);

    String gerarToken(String email);
}

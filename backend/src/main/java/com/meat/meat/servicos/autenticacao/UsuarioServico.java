package com.meat.meat.servicos.autenticacao;


import com.meat.meat.entidades.dtos.UsuarioDTO;

public interface UsuarioServico {

    UsuarioDTO cadastrar(UsuarioDTO usuarioDTO);

    UsuarioDTO logar(UsuarioDTO usuarioDTO);

}

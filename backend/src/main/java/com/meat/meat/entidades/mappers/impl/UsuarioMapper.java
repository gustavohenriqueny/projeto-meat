package com.meat.meat.entidades.mappers.impl;

import com.meat.meat.entidades.Usuario;
import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.entidades.mappers.EntidadeMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioMapper implements EntidadeMapper<UsuarioDTO, Usuario> {

    private final ModelMapper mapper;

    @Override
    public Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
        return mapper.map(usuarioDTO, Usuario.class);
    }

    @Override
    public UsuarioDTO converterParaDto(Usuario entidade) {
        return mapper.map(entidade, UsuarioDTO.class);
    }

    @Override
    public List<Usuario> converterListaParaEntidades(List<UsuarioDTO> usuarioDTOS) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioDTOS.forEach(usuarioDTO -> usuarios.add(converterParaEntidade(usuarioDTO)));
        return usuarios;
    }

    @Override
    public List<UsuarioDTO> converterListaParaDtos(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        usuarios.forEach(usuario -> usuarioDTOS.add(converterParaDto(usuario)));
        return usuarioDTOS;
    }
}

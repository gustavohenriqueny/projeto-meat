package com.meat.meat.servicos.autenticacao;

import com.meat.meat.entidades.Usuario;
import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.entidades.mappers.impl.UsuarioMapper;
import com.meat.meat.repositorios.UsuarioRepositorio;
import com.meat.meat.servicos.jwt.JwtServico;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServicoImpl implements UsuarioServico {

    private final Logger logger = LoggerFactory.getLogger(UsuarioServicoImpl.class);
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder codificador;
    private final JwtServico jwtServico;
    private final AuthenticationManager authenticationManager;

    @Override
    public UsuarioDTO cadastrar(UsuarioDTO usuario) {
        usuario.setSenha(codificador.encode(usuario.getSenha()));
        usuarioRepositorio.save(usuarioMapper.converterParaEntidade(usuario));
        return UsuarioDTO.builder().nome(usuario.getNome()).token(jwtServico.gerarToken(usuario.getEmail())).build();
    }

    @Override
    public UsuarioDTO logar(UsuarioDTO usuarioDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                usuarioDTO.getEmail(),
                usuarioDTO.getSenha()
            )
        );
        Usuario usuario = usuarioRepositorio.findByEmail(usuarioDTO.getEmail()).orElseThrow();
        return UsuarioDTO.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .email(usuario.getEmail())
            .token(jwtServico.gerarToken(usuario.getEmail())).build();
    }

}

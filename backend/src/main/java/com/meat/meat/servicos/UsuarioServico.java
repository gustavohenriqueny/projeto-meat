package com.meat.meat.servicos;

import com.meat.meat.entidades.Usuario;
import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.entidades.enums.Permissao;
import com.meat.meat.entidades.enums.Status;
import com.meat.meat.repositorios.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder codificador;
    private final JwtServico jwtServico;
    private final AuthenticationManager authenticationManager;

    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario.builder()
            .nome(usuarioDTO.getNome())
            .email(usuarioDTO.getEmail())
            .senha(codificador.encode(usuarioDTO.getSenha()))
            .status(Status.ATIVO)
            .dataCriacao(new Timestamp(new Date(System.currentTimeMillis()).getTime()))
            .permissao(Permissao.USUARIO)
            .build();
        usuarioRepositorio.save(usuario);
        String token = jwtServico.gerarToken(usuario);
        return UsuarioDTO.builder().nome(usuario.getNome()).token(token).build();
    }

    public UsuarioDTO logar(UsuarioDTO usuarioDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                usuarioDTO.getEmail(),
                usuarioDTO.getSenha()
            )
        );
        Usuario usuario = usuarioRepositorio.findByEmail(usuarioDTO.getEmail()).orElseThrow();
        String token = jwtServico.gerarToken(usuario);
        return UsuarioDTO.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .email(usuario.getEmail())
            .token(token).build();
    }

    public UsuarioDTO obterUsuarioPorToken(String token) {
        return usuarioRepositorio.findByToken(token).orElseThrow();
    }

}

package com.meat.meat.web.rest;

import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.servicos.autenticacao.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@RequiredArgsConstructor
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServico.cadastrar(usuarioDTO));
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioDTO> logar(@RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioServico.logar(usuario));
    }

}

package com.meat.meat.web.rest;

import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.servicos.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
@RequiredArgsConstructor
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServico.cadastrar(usuarioDTO));
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioDTO> logar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServico.logar(usuarioDTO));
    }

    @PostMapping("/obterUsuario")
    public ResponseEntity<UsuarioDTO> obterUsuario(@RequestBody String token) {
        return ResponseEntity.ok(usuarioServico.obterUsuarioPorToken(token));
    }
}

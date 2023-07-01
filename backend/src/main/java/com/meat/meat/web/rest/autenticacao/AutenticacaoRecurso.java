package com.meat.meat.web.rest.autenticacao;

import com.meat.meat.entidades.dtos.UsuarioDTO;
import com.meat.meat.servicos.autenticacao.AutenticacaoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoRecurso {

    private final AutenticacaoServico autenticacaoServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(autenticacaoServico.cadastrar(usuarioDTO));
    }

    @PostMapping("/logar")
    public ResponseEntity<UsuarioDTO> logar(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(autenticacaoServico.logar(usuarioDTO));
    }
}

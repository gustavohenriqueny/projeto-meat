package com.meat.meat.web.rest.autenticacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteRecurso {

    @GetMapping
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("teste");
    }

}

package com.meat.meat.web.rest;

import com.meat.meat.entidades.dtos.RestauranteDTO;
import com.meat.meat.servicos.restaurante.RestauranteServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteRecurso {

    private final RestauranteServico restauranteServico;

    @GetMapping("/restaurantes")
    public ResponseEntity<List<RestauranteDTO>> buscarTodosRestaurantes(@RequestParam(required = false) String pesquisa) {
        return ResponseEntity.ok(restauranteServico.buscarRestaurantes(pesquisa));
    }

    @GetMapping("/restaurante/{idRestaurante}")
    public ResponseEntity<RestauranteDTO> buscarRestaurantePorId(@PathVariable(name = "idRestaurante") Long idRestaurante) {
        return ResponseEntity.ok(restauranteServico.buscarRestaurantePorId(idRestaurante));
    }
    
}

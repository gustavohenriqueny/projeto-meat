package com.meat.meat.servicos.restaurante;

import com.meat.meat.entidades.dtos.RestauranteDTO;

import java.util.List;

public interface RestauranteServico {
    List<RestauranteDTO> buscarRestaurantes(String pesquisa);

    RestauranteDTO buscarRestaurantePorId(Long idRestaurante);
}

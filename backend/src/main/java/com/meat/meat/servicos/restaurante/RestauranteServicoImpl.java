package com.meat.meat.servicos.restaurante;

import com.meat.meat.entidades.dtos.RestauranteDTO;
import com.meat.meat.entidades.mappers.impl.RestauranteMapper;
import com.meat.meat.repositorios.RestauranteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServicoImpl implements RestauranteServico {

    private final RestauranteMapper restauranteMapper;
    private final RestauranteRepositorio restauranteRepositorio;

    @Override
    public List<RestauranteDTO> buscarRestaurantes(String pesquisa) {
        return restauranteRepositorio.buscarRestaurantes(pesquisa).orElse(new ArrayList<>()).stream().map(restauranteMapper::converterParaDto).toList();
    }

    @Override
    public RestauranteDTO buscarRestaurantePorId(Long idRestaurante) {
        return restauranteMapper.converterParaDto(restauranteRepositorio.findById(idRestaurante).orElseThrow());
    }

}

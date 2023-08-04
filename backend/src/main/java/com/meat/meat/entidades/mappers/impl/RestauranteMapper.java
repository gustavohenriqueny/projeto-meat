package com.meat.meat.entidades.mappers.impl;

import com.meat.meat.entidades.Restaurante;
import com.meat.meat.entidades.dtos.RestauranteDTO;
import com.meat.meat.entidades.mappers.EntidadeMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestauranteMapper implements EntidadeMapper<RestauranteDTO, Restaurante> {

    private final ModelMapper mapper;

    @Override
    public Restaurante converterParaEntidade(RestauranteDTO restauranteDTO) {
        return mapper.map(restauranteDTO, Restaurante.class);
    }

    @Override
    public RestauranteDTO converterParaDto(Restaurante entidade) {
        return mapper.map(entidade, RestauranteDTO.class);
    }

    @Override
    public List<Restaurante> converterListaParaEntidades(List<RestauranteDTO> dtos) {
        List<Restaurante> restaurantes = new ArrayList<>();
        dtos.forEach(restauranteDTO -> restaurantes.add(converterParaEntidade(restauranteDTO)));
        return restaurantes;
    }

    @Override
    public List<RestauranteDTO> converterListaParaDtos(List<Restaurante> entidades) {
        List<RestauranteDTO> restaurantesDTOS = new ArrayList<>();
        entidades.forEach(entidade -> restaurantesDTOS.add(converterParaDto(entidade)));
        return restaurantesDTOS;
    }

}

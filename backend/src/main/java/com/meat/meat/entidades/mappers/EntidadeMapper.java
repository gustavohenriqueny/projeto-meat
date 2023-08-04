package com.meat.meat.entidades.mappers;

import java.util.List;

public interface EntidadeMapper<D, E> {

    E converterParaEntidade(D dto);

    D converterParaDto(E entidade);

    List<E> converterListaParaEntidades(List<D> dtos);

    List<D> converterListaParaDtos(List<E> entidades);

}

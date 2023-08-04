package com.meat.meat.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO implements Serializable {

    private Long id;
    private String nome;
    private String categoria;
    private String prazoEntrega;
    private String caminhoImagem;
    private String sobre;
    private String horarioFuncionamento;
    private MenuDTO menu;
    private List<AvaliacaoDTO> avaliacoes;

}

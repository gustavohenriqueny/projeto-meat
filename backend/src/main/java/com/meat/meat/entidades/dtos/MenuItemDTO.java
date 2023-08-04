package com.meat.meat.entidades.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String caminhoImagem;

}

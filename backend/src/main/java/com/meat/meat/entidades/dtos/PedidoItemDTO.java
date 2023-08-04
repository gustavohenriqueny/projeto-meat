package com.meat.meat.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemDTO implements Serializable {

    private Long id;
    private MenuItemDTO menuItem;
    private Integer quantidade;

}

package com.meat.meat.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO implements Serializable {

    private Long id;
    private String endereco;
    private String numero;
    private String enderecoOpcional;
    private Timestamp dataPedido;
    private String metodoPagamento;
    private UsuarioDTO usuario;
    private List<PedidoItemDTO> pedidosItems;

    public PedidoDTO(Long id) {
        this.id = id;
    }

}

package com.meat.meat.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO implements Serializable {

    private Long id;
    private String nome;
    private String avaliacao;
    private String comentario;
    private LocalDateTime dataAvaliacao;

}

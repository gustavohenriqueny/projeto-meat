package com.meat.meat.entidades.dtos;

import com.meat.meat.entidades.enums.Permissao;
import com.meat.meat.entidades.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Timestamp dataCriacao;
    private Permissao permissao;
    private Status status;
    private String token;


}

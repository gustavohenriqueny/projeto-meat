package com.meat.meat.entidades.dtos;

import com.meat.meat.entidades.enums.Permissao;
import com.meat.meat.entidades.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Timestamp dataCriacao = ObjectUtils.clone(new Timestamp(new Date().getTime()));
    private Permissao permissao = Permissao.ADMINISTRADOR;
    private Status status = Status.ATIVO;
    private String token;

}

package com.meat.meat.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "prazo_entrega")
    private String prazoEntrega;

    @Column(name = "caminho_imagem")
    private String caminhoImagem;

    @Column(name = "sobre")
    private String sobre;

    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    private Menu menu;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurante")
    private List<Avaliacao> avaliacoes;

}

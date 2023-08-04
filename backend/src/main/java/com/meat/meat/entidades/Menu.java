package com.meat.meat.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @OneToOne(mappedBy = "menu")
    private Restaurante restaurante;

    @JsonManagedReference
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<MenuItem> menuItems;

}

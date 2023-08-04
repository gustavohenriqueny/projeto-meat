package com.meat.meat.repositorios;

import com.meat.meat.entidades.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long> {


    @Query("select restaurante from " +
        "Restaurante restaurante " +
        "where lower(restaurante.nome) like concat('%',  lower(:pesquisa), '%') or :pesquisa is null " +
        "or lower(restaurante.categoria) like concat('%', lower(:pesquisa) , '%') or :pesquisa is null ")
    Optional<List<Restaurante>> buscarRestaurantes(String pesquisa);
}

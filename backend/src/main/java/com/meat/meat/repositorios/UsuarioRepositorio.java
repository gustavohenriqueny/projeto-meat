package com.meat.meat.repositorios;

import com.meat.meat.entidades.Usuario;
import com.meat.meat.entidades.dtos.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<UsuarioDTO> findByToken(String token);
}

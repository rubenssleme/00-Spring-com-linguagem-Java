package com.exemplo.organ.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.organ.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}

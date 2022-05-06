package com.curso2020.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}

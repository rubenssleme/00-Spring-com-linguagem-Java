package com.exemplo.organ.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.organ.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}

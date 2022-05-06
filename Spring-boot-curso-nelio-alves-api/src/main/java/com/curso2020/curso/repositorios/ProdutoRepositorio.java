package com.curso2020.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}

package com.exemplo.organ.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.organ.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}

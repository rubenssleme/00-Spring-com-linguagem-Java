package br.com.petz.parceirosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.parceirosapi.entity.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

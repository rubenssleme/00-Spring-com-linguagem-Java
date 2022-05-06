package com.curso2020.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}

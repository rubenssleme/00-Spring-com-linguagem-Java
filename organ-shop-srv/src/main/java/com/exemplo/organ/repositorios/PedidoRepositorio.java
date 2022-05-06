package com.exemplo.organ.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.organ.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}

package com.exemplo.organ.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.organ.entidades.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long> {

}

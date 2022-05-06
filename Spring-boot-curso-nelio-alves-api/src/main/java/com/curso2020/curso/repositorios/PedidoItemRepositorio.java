package com.curso2020.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso2020.curso.entidades.Pedido;
import com.curso2020.curso.entidades.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long> {

}

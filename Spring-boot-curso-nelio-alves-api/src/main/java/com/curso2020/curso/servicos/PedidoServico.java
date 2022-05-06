package com.curso2020.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso2020.curso.entidades.Pedido;
import com.curso2020.curso.repositorios.PedidoRepositorio;
@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio  pedidoRepositorio;
	
	public List<Pedido> findAll(){
		return pedidoRepositorio.findAll();
		
	}
	
	public Pedido findById(Long id ) {
		Optional<Pedido> obj = pedidoRepositorio.findById(id);
		return obj.get();
	}
}

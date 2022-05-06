package br.com.petz.parceirosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.parceirosapi.entity.Parceiro;
import br.com.petz.parceirosapi.entity.Pedido;
import br.com.petz.parceirosapi.repository.PedidoRepository;
@Service
public class PedidoService {

	@Autowired
	private PedidoRepository  repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
		
	}
	
	public Pedido findById(Long id ) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return repositorio.save(obj);
	}
}

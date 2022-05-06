package br.com.petz.parceirosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.parceirosapi.entity.Produto;
import br.com.petz.parceirosapi.repository.ProdutoRepository;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	public List<Produto> findAll() {
		return repositorio.findAll();

	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

	public Produto insert(Produto obj) {
		return repositorio.save(obj);
	}
}

package br.com.petz.parceirosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.parceirosapi.entity.Cliente;
import br.com.petz.parceirosapi.entity.Parceiro;
import br.com.petz.parceirosapi.repository.ClienteRepository;
import br.com.petz.parceirosapi.repository.ParceiroRepository;

@Service
public class ParceiroService {

	@Autowired
	private ParceiroRepository repositorio;

	public List<Parceiro> findAll() {
		return repositorio.findAll();

	}

	public Parceiro findById(Long id) {
		Optional<Parceiro> obj = repositorio.findById(id);
		return obj.get();
	}

	public Parceiro insert(Parceiro obj) {
		return repositorio.save(obj);
	}
}

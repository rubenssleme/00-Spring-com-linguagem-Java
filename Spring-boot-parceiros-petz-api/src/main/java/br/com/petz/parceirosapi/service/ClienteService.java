package br.com.petz.parceirosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.parceirosapi.entity.Cliente;
import br.com.petz.parceirosapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	public List<Cliente> findAll() {
		return repositorio.findAll();

	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.get();
	}

	public Cliente insert(Cliente obj) {
		return repositorio.save(obj);
	}
}

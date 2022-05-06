package com.curso2020.curso.recursos;

import java.net.URI;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso2020.curso.entidades.Categoria;
import com.curso2020.curso.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaServico servico;

	@ApiOperation(value = "Busca por id")
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Busca por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@ApiOperation(value = "Busca por id")
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}

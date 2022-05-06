package br.com.petz.parceirosapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.petz.parceirosapi.dto.CategoriaDTO;
import br.com.petz.parceirosapi.entity.Categoria;
import br.com.petz.parceirosapi.service.CategoriaServico;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping(value="/categorias")
public class CategoriaRecurso {

	@Autowired
	private CategoriaServico servico;

	
	@ApiOperation(value = "Busca por id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Busca todas Categorias")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value="Insere Categoria")
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiOperation(value="Atualiza Categoria")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Long id) {
		Categoria obj = servico.fromDTO(objDto);
        obj.setId(id);
        obj = servico.update(obj);
        return ResponseEntity.noContent().build();
    }
	
	@ApiOperation(value="Deleta Categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
            @ApiResponse(code = 404, message = "Código inexistente") })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servico.delete(id);
        return ResponseEntity.noContent().build();
    }
	
	

}

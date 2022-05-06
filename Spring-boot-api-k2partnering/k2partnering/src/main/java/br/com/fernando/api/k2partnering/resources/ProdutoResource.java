package br.com.fernando.api.k2partnering.resources;

import br.com.fernando.api.k2partnering.domain.Produtos;
import br.com.fernando.api.k2partnering.dto.ProdutoDTO;
import br.com.fernando.api.k2partnering.service.ProdutoService;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;
    @ApiOperation(value="Busca Produto por id")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Produtos> find(@PathVariable Integer id) {
        Produtos obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Busca todos Produtos")
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produtos> list = service.findAll();
        List<ProdutoDTO> listDto = list.stream().map (ProdutoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok ().body (listDto);
    }
    @ApiOperation(value="Insere Produto")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDTO objDto) {
        Produtos obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
package br.com.petz.parceirosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.petz.parceirosapi.dto.CategoriaDTO;
import br.com.petz.parceirosapi.entity.Categoria;
import br.com.petz.parceirosapi.repository.CategoriaRepository;
import br.com.petz.parceirosapi.service.exception.DataIntegrityException;



@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepository repositorio;

	public List<Categoria> findAll() {
		return repositorio.findAll();

	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

	public Categoria insert(Categoria obj) {
		return repositorio.save(obj);
	}
	 public Categoria update(Categoria obj) {
	        Categoria newObj = findById(obj.getId());
	        updateData(newObj, obj);
	        return repositorio.save(newObj);
	    }
	
	 public Categoria fromDTO(CategoriaDTO objDto) {
	        return new Categoria(objDto.getId(), objDto.getCategoria());
	    }
	 private void updateData(Categoria newObj, Categoria obj) {
	        newObj.setNome(obj.getNome());
	    }

	 public void delete(Long id) {
	        findById(id);
	        try {
	            repositorio.deleteById(id);
	        } catch (DataIntegrityViolationException e) {
	            throw new DataIntegrityException("Não é possivel exluir uma categoria que possiu produtos.");
	        }
	    }
}

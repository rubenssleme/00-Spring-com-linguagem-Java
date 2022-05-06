package br.com.fernando.api.k2partnering.service;

import br.com.fernando.api.k2partnering.domain.Categorias;
import br.com.fernando.api.k2partnering.dto.CategoriaDTO;
import br.com.fernando.api.k2partnering.repository.CategoriaRepository;
import br.com.fernando.api.k2partnering.service.exception.DataIntegrityExecpition;
import br.com.fernando.api.k2partnering.service.exception.ObjectNotFoundExecpition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categorias find(Integer id) {
        Optional<Categorias> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
                "Objeto nao encontrado! Id: " + id
                        + " Tipo: " + Categorias.class.getSimpleName()));
    }

    public Categorias insert(Categorias obj) {
        obj.setId(null);
        return repo.saveAndFlush(obj);
    }

    public Categorias update(Categorias obj) {
        Categorias newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityExecpition("Não é possivel exluir uma categoria que possiu produtos.");
        }
    }

    public List<Categorias> findAll() {
        return repo.findAll();
    }

    public Categorias fromDTO(CategoriaDTO objDto) {
        return new Categorias(objDto.getId(), objDto.getCategoria());
    }

    private void updateData(Categorias newObj, Categorias obj) {
        newObj.setCategoria(obj.getCategoria());
    }

}
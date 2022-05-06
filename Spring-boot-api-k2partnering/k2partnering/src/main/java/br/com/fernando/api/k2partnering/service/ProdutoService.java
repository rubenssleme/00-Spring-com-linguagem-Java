package br.com.fernando.api.k2partnering.service;

import br.com.fernando.api.k2partnering.domain.Categorias;
import br.com.fernando.api.k2partnering.domain.Produtos;
import br.com.fernando.api.k2partnering.dto.ProdutoDTO;
import br.com.fernando.api.k2partnering.repository.CategoriaRepository;
import br.com.fernando.api.k2partnering.repository.ProdutoRepository;
import br.com.fernando.api.k2partnering.service.exception.ObjectNotFoundExecpition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;
    @Autowired
    private CategoriaService categoriaService;

    public Produtos find(Integer id) {
        Optional<Produtos> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
                "Objeto nao encontrado! Id: " + id
                        + " Tipo: " + Categorias.class.getSimpleName()));
    }

    public Produtos insert(Produtos obj) {
        obj.setId(null);
        return repo.saveAndFlush(obj);
    }

    public List<Produtos> findAll() {
        return repo.findAll();
    }

    public Produtos fromDTO(ProdutoDTO objDto) {
        return new Produtos(
                objDto.getId(),objDto.getCategorias(),objDto.getNome(),
                objDto.getPreco(), objDto.getQuantidade(),objDto.getDescricao(),objDto.getFoto());
    }
}
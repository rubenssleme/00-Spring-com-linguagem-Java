package br.com.fernando.api.k2partnering.repository;



import br.com.fernando.api.k2partnering.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos,Integer> {

}

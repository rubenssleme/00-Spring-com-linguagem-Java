package br.com.fernando.api.k2partnering.repository;

import br.com.fernando.api.k2partnering.domain.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias,Integer> {
}

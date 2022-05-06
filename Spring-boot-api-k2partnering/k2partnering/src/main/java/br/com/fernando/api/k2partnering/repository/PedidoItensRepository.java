package br.com.fernando.api.k2partnering.repository;

import br.com.fernando.api.k2partnering.domain.PedidoItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItensRepository extends JpaRepository<PedidoItens,Integer> {
}

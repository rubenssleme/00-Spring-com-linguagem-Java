package br.com.petz.parceirosapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petz.parceirosapi.entity.Cliente;
import br.com.petz.parceirosapi.entity.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro ,Long> {
}

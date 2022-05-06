package br.com.fernando.api.k2partnering.repository;

import br.com.fernando.api.k2partnering.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes ,Integer> {

    @Transactional(readOnly=true)
    Clientes findByEmail(String email);
}

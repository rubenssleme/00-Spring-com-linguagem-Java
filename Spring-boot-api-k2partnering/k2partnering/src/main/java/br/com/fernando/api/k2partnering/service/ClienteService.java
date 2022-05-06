package br.com.fernando.api.k2partnering.service;

import br.com.fernando.api.k2partnering.domain.Clientes;
import br.com.fernando.api.k2partnering.domain.enums.Perfil;
import br.com.fernando.api.k2partnering.dto.ClienteDTO;
import br.com.fernando.api.k2partnering.dto.ClienteNewDTO;
import br.com.fernando.api.k2partnering.repository.ClienteRepository;
import br.com.fernando.api.k2partnering.security.UserSS;
import br.com.fernando.api.k2partnering.service.exception.AuthorizationException;
import br.com.fernando.api.k2partnering.service.exception.DataIntegrityExecpition;
import br.com.fernando.api.k2partnering.service.exception.ObjectNotFoundExecpition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;


    @Autowired
    private BCryptPasswordEncoder pe;

    public Clientes find(Integer id) {

        UserSS user = UserService.authenticated();
        if (user == null || user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }
        Optional<Clientes> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
                "Objeto nao encontrado! Id: " + id + " Tipo: " + Clientes.class.getSimpleName()));
    }

    @Transactional
    public Clientes insert(Clientes obj) {
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public Clientes fromDTO(ClienteNewDTO objDto) {
        Clientes cli = new Clientes(
                objDto.getId(),objDto.getNome(),objDto.getEmail(),
                objDto.getSenha(),objDto.getRua(),objDto.getCidade(),
                objDto.getBairro(),objDto.getCep(),objDto.getEstado()
        );
        return cli;
    }

    public Clientes update(Clientes obj) {
        Clientes newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.saveAndFlush(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityExecpition("Não é possível excluir porque há pedidos relacionados");
        }
    }

    public List<Clientes> findAll() {
        return repo.findAll();
    }

    public Clientes findByEmail(String email) {
        UserSS user = UserService.authenticated();
        if (user == null || user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }
        Clientes obj = repo.findByEmail(email);
        if (obj == null) {
            throw new ObjectNotFoundExecpition(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Clientes.class.getSimpleName());
        }
        return obj;
    }

    public Page<Clientes> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Clientes fromDTO(ClienteDTO objDto) {
        return new Clientes(objDto.getId(),objDto.getNome(),objDto.getEmail());
    }

    private void updateData(Clientes newObj, Clientes obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}

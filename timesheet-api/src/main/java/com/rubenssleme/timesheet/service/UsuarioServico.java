package com.rubenssleme.timesheet.service;

import com.rubenssleme.timesheet.entities.Usuario;
import com.rubenssleme.timesheet.repository.UsuarioRepositorio;
import com.rubenssleme.timesheet.service.exceptions.DatabaseException;
import com.rubenssleme.timesheet.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();

    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepositorio.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario obj) {
        return usuarioRepositorio.save(obj);
    }

    public void delete(Long id) {
        try {
            usuarioRepositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public Usuario update(Long id, Usuario obj) {
        try {

            Usuario entity = usuarioRepositorio.getOne(id);
            updateData(entity,obj);
            return usuarioRepositorio.save(entity);

        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());

    }


}

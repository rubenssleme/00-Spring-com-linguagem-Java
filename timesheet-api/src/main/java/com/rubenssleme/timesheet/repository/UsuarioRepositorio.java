package com.rubenssleme.timesheet.repository;

import com.rubenssleme.timesheet.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}

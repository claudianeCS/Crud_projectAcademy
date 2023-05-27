package com.project.academy.repository;

import com.project.academy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.Email;
import java.util.List;

public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u from Usuario u where u.email = :email")
    public Usuario findByEmail(String email);


}

package com.project.academy.service;

import com.project.academy.exeception.CriptException;
import com.project.academy.exeception.EmailException;
import com.project.academy.model.Usuario;
import com.project.academy.repository.UsuarioRespository;
import com.project.academy.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService {

    @Autowired // injeção de depedencia
    private UsuarioRespository usuarioRespository;
    public void salvarUsuario(Usuario usuario) throws Exception{
        //regra verificar se ja tem email cadastrado
        try {
            if (usuarioRespository.findByEmail(usuario.getEmail()) != null){
                throw new EmailException("Ja existe um email cadastrado" + usuario.getEmail());
            }
            usuario.setSenha(Util.md5(usuario.getSenha())); // pega a senha e seta para a criptografia md5 criada
        } catch (NoSuchAlgorithmException e){
            throw new CriptException("Erro na criptografia da senha");
        }

        usuarioRespository.save(usuario);
    }
}

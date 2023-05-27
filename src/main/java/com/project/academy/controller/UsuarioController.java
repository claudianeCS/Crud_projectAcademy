package com.project.academy.controller;

import com.project.academy.model.Usuario;
import com.project.academy.repository.UsuarioRespository;
import com.project.academy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("index")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        return mv;
    }

    @GetMapping("cadastro")
    public ModelAndView cadastroUsuario(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/cadastroUsuario");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView salvar(Usuario usuario) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/index");
        usuarioService.salvarUsuario(usuario);
        return mv;
    }

}

package com.project.academy.controller;

import com.project.academy.model.Aluno;
import com.project.academy.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    @GetMapping("inserirAluno")
    public ModelAndView inserirAluno(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/formAluno");
        //enviar o objeto Aluno para a view
        mv.addObject("aluno", new Aluno()); //atributoName , atributoValue : nome e valor que serao repassados na view de acordo com a operação
        return mv;
    }

    @PostMapping("insertAlunos")
    public ModelAndView inserirAlunos(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/alunos");
        alunoRepository.save(aluno);
        return mv;
    }

    //OBS: alunoRepository.findAll() retorna uma List<Aluno> ListCrudRepository
    @GetMapping("alunos")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        mv.addObject("alunosList", alunoRepository.findAll()); // vai achar todos os dados contentes na tabela atraves do repositorio e colocar em alunosList
        return mv;
    }


    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id")Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alterar");
        Aluno aluno = alunoRepository.getOne(id); //reponsavel por pegar o id
        mv.addObject("aluno", aluno);
        return mv;
    }


    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        alunoRepository.save(aluno);
        mv.setViewName("redirect:alunos");
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable("id")Integer id) {
        alunoRepository.deleteById(id);
        return "redirect:/alunos";
    }

    @GetMapping("filtrarAlunos")
    public ModelAndView filtroAluno(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/filtroAlunos");
        return mv;
    }

    @GetMapping("alunosAtivos")
    public ModelAndView listaAtivos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alunosListados");
        mv.addObject("alunosAtivos", alunoRepository.findByStatusAtivo()); // vai achar todos os dados contentes na tabela atraves do repositorio e colocar em alunosList
        return mv;
    }
}

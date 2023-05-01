package com.Academy.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Academy.project.model.Aluno;
import com.Academy.project.repository.AlunoRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/inserirAluno") // Get = pegue - metodo que possui retorno
	public ModelAndView insertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/formAluno");
		//enviar o objeto Aluno para a view
		mv.addObject("aluno", new Aluno()); //atributoName , atributoValue : nome e valor que serao repassados na view de acordo com a operação
		return mv;
	}
	
	@PostMapping("insertAlunos")  // inseri as informações de Aluno no banco de dados
	public ModelAndView inserirAluno(Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("Aluno/formAluno");
			mv.addObject("aluno");
		}else {
			mv.setViewName("redirect:alunos");
			alunoRepository.save(aluno);
			/* System.out.println("Ola Mundo"); */
		}
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
		Aluno aluno = alunoRepository.getReferenceById(id); //reponsavel por pegar o id
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoRepository.save(aluno);
		mv.setViewName("redirect:/alunos");
		return mv;
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarAluno(@PathVariable("id")Integer id) {
		alunoRepository.deleteById(id);
		return "redirect:/alunos";
	}
}

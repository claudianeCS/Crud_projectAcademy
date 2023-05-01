package com.Academy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Academy.project.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}

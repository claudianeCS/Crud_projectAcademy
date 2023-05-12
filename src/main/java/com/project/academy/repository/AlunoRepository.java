package com.project.academy.repository;

import com.project.academy.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


    //jpql java persisten query lenguage
    @Query("SELECT j FROM Aluno j WHERE j.status = 'ATIVO' ")
    public List<Aluno> findByStatusAtivo();


}

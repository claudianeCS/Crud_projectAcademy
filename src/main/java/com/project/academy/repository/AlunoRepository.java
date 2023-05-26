package com.project.academy.repository;

import com.project.academy.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {


    //jpql java persisten query lenguage
    @Query("SELECT a FROM Aluno a WHERE a.status = 'Ativo'")
    public List<Aluno> findByStatusAtivo();

    @Query("SELECT i FROM Aluno i WHERE i.status = 'Inativo' ")
    public List<Aluno> findByStatusInativo();

    @Query("SELECT t FROM Aluno t WHERE t.status = 'Trancado' ")
    public List<Aluno> findByStatusTrancado();

    @Query("SELECT c FROM Aluno c WHERE c.status = 'Cancelado' ")
    public List<Aluno> findByStatusCancelado();

    public List<Aluno> findByNomeContainingIgnoreCase(String nome);

}

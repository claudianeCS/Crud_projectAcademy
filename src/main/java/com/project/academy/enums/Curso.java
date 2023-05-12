package com.project.academy.enums;

public enum Curso {
    ADMINISTRACAO("Administracao"),
    INFORMATICA("Informatica"),
    CONTABILIDADE("Contabilidade"),
    PROGRAMACAO("Programacao"),
    ENFERMAGEM("Enfermagem");

    private String curso;

    //construtor com o atributo declarado acima
    private Curso(String curso) {
        this.curso = curso; //chamar o enum no model
    }
}

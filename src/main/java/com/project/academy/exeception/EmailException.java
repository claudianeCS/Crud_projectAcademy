package com.project.academy.exeception;

import java.io.Serial;

public class EmailException extends Exception {
    public EmailException(String message) {
        super(message);
    }
    @Serial
    private static final long serialVersionUID = 1L; //definição da versao da classe
}

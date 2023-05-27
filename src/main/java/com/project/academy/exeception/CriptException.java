package com.project.academy.exeception;

import java.io.Serial;

public class CriptException extends Exception {
    public CriptException(String message) {
        super(message);
    }
    @Serial
    private static final long serialVersionUID = 1L;
}

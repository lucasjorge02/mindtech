package com.team.build.mindtech.exception.bussiness;

public class EmailCadastradoException extends RuntimeException {
    public EmailCadastradoException() {
        super("Email  já cadastrado");
    }
}

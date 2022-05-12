package com.adafpc.letscode.microservico.autentificacao.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String login) {
        super("No user found for login " + login);
    }
}

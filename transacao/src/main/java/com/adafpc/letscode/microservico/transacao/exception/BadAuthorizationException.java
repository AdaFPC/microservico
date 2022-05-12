package com.adafpc.letscode.microservico.transacao.exception;

public class BadAuthorizationException extends RuntimeException{
    public BadAuthorizationException() {
        super("Invalid Authorization");
    }
}

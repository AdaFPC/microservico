package com.adafpc.letscode.microservico.transacao.exception;

public class UnexpectedParameterException extends RuntimeException{
    public UnexpectedParameterException(String message) {
        super(message+" should be empty, value received");
    }
}

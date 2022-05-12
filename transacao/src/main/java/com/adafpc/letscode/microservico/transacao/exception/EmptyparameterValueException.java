package com.adafpc.letscode.microservico.transacao.exception;

public class EmptyparameterValueException extends RuntimeException{
    public EmptyparameterValueException(String message) {
        super(message+" should not be empty");
    }
}

package com.hygorluciano.forumalura.infra.exception;

public class CriacaoInvalidoException extends RuntimeException{

    public CriacaoInvalidoException(String message) {
        super(message);
    }

    public CriacaoInvalidoException() {
    }

    public CriacaoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.hygorluciano.forumalura.infra.exception;

public class IdInvalidoException extends  RuntimeException{

    public IdInvalidoException(String message) {
        super(message);
    }

    public IdInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}

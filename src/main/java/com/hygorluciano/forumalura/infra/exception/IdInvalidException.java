package com.hygorluciano.forumalura.infra.exception;

public class IdInvalidException extends  RuntimeException{

    public IdInvalidException(String message) {
        super(message);
    }

    public IdInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
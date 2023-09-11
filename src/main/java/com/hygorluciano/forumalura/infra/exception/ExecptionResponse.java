package com.hygorluciano.forumalura.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExecptionResponse {
    @ExceptionHandler(value = {IdInvalidoException.class})
    private ResponseEntity<?> idExcption(IdInvalidoException ex, WebRequest webRequest){
        Map<String,Object> body = new HashMap<>();
        body.put("Erro","Valor informado não existe");
        HttpStatus status = HttpStatus.NOT_FOUND;
        body.put("ID",ex.getMessage());
        return new ResponseEntity<>(body, status);
    }
    @ExceptionHandler(value = {CriacaoInvalidoException.class})
    private ResponseEntity<?> criacaoErro(CriacaoInvalidoException ex, WebRequest webRequest){
        Map<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("Erro", "Erro na criação, Verificar os valores passados");
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        bodyMap.put("Erro no valor passado",ex.getMessage());
        return  new ResponseEntity<>(bodyMap, status);
    }

}

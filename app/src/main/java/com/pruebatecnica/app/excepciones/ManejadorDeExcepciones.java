package com.pruebatecnica.app.excepciones;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ManejadorDeExcepciones {
    @ExceptionHandler(RecursoNoEncontradoExcepcion.class)
    public ResponseEntity<?> recursoNoEncontradoExcepcion(RecursoNoEncontradoExcepcion ex, WebRequest request) {
        DetallesDeErrores DetallesDeErrores = new DetallesDeErrores(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(DetallesDeErrores, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ErrorDeTipoExcepcion.class)
    public ResponseEntity<?> errorDeTipoExcepcion(ErrorDeTipoExcepcion ex, WebRequest request) {
        DetallesDeErrores DetallesDeErrores = new DetallesDeErrores(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(DetallesDeErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        DetallesDeErrores DetallesDeErrores = new DetallesDeErrores(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(DetallesDeErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
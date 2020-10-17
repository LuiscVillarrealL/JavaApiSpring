package com.pruebatecnica.app.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorDeTipoExcepcion extends Exception{
	
	 public ErrorDeTipoExcepcion(String message){
	        super(message);
	    }

}

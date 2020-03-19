package com.ac.curso.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ac.curso.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {
	
	
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(System.currentTimeMillis(), 
				status.value(), 
				"Não encontrado", 
				e.getMessage(), 
				request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(err);
	}
}

package com.curso2020.curso.servicos.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
	
}

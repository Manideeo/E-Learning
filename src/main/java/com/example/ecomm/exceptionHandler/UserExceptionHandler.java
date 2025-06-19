package com.example.ecomm.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ecomm.exception.IdNotFoundException;
import com.example.ecomm.util.ResponseStructure;

 
@RestControllerAdvice
public class UserExceptionHandler {
	
	ResponseStructure<String> structure = new ResponseStructure<>();
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFoundException idNotFound) {
		structure.setData(idNotFound.getMessage());
		structure.setMsg("Id not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}


}

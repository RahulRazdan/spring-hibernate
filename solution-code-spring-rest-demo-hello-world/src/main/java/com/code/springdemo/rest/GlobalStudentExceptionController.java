package com.code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalStudentExceptionController {

	
	@ExceptionHandler
	public ResponseEntity<StudentResponseError> handleException(StudentNotFoundException ex){
		
		StudentResponseError error = new StudentResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(error,	HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponseError> allExceptions(Exception ex) {
		
		StudentResponseError error = new StudentResponseError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(error,	HttpStatus.BAD_REQUEST);
	}
}

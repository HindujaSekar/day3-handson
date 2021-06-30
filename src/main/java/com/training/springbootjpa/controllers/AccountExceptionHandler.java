package com.training.springbootjpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.springbootjpa.exceptions.ErrorDto;
import com.training.springbootjpa.exceptions.NoSuchAccountException;
import com.training.springbootjpa.exceptions.StateNotFoundException;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchAccountException.class)
	protected ResponseEntity<ErrorDto> handleWhenNoAccountFound(RuntimeException e){
		return new ResponseEntity<>(ErrorDto
				.builder()
				.errorCode(404)
				.errorMessage(e.getMessage())
				.build(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StateNotFoundException.class)
	protected ResponseEntity<ErrorDto> handleWhenNoAccountWithStateFound(RuntimeException e){
		return new ResponseEntity<>(ErrorDto
				.builder()
				.errorCode(404)
				.errorMessage(e.getMessage())
				.build(), HttpStatus.NOT_FOUND);
	}

}

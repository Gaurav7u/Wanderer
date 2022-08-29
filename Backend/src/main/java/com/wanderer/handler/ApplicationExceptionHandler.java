package com.wanderer.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wanderer.exception.NotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> notFoundHandler(NotFoundException notFoundException)
	{
		return new ResponseEntity<>(notFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
}

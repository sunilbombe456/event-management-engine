package com.webwork.eventmanagementengine.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webwork.eventmanagementengine.entity.ResponseError;
import com.webwork.eventmanagementengine.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public ResponseEntity<ResponseError> handleExcption(UserNotFoundException exc) {

		ResponseError error = new ResponseError();

		error.setStatus(HttpStatus.NOT_FOUND.value());

		error.setMessage(exc.getMessage());

		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// To Handle all Kind of Exception
	
	@ExceptionHandler
	public ResponseEntity<ResponseError> handleExcption(Exception exc) {

		ResponseError error = new ResponseError();

		error.setStatus(HttpStatus.NOT_FOUND.value());

		error.setMessage(exc.getMessage());

		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}

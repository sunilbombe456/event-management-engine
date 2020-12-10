package com.webwork.event.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webwork.event.management.dto.ResponseError;
import com.webwork.event.management.exception.AuthorizationException;
import com.webwork.event.management.exception.DuplicateEntityException;
import com.webwork.event.management.exception.EntityNotFoundException;
import com.webwork.event.management.exception.FileNotFoundException;
import com.webwork.event.management.exception.UserNotFoundException;

//extends ResponseEntityExceptionHandler
@ControllerAdvice
public class CustomExceptionHandler {

	private ResponseError error;

	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	private String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ResponseError> handleAuthorizationException(AuthorizationException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<ResponseError> handleFileNotFoundException(FileNotFoundException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> handleUserNotFoundException(UserNotFoundException exc) {
		error = new ResponseError(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseError> handleEntityNotFoundException(EntityNotFoundException exc) {
		error = new ResponseError(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateEntityException.class)
	public ResponseEntity<ResponseError> handleDuplicateEntityException(DuplicateEntityException exc) {
		error = new ResponseError(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// To Handle all Kind of Exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exc, WebRequest request) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationErrorHandling(MethodArgumentNotValidException exe) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getBindingResult().getFieldError().getDefaultMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

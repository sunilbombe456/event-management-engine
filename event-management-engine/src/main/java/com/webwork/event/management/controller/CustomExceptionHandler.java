package com.webwork.event.management.controller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webwork.event.management.dto.ResponseError;
import com.webwork.event.management.exception.AuthorizationException;
import com.webwork.event.management.exception.FileNotFoundException;
import com.webwork.event.management.exception.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	private String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ResponseError> handleException(AuthorizationException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<ResponseError> handleException(FileNotFoundException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> handleException(UserNotFoundException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequestRejectedException.class)
	public ResponseEntity<ResponseError> handleException(RequestRejectedException exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getLocalizedMessage().toString());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	// To Handle all Kind of Exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> handleException(Exception exc) {
		ResponseError error = new ResponseError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler
//	public ResponseEntity<?> handleException(MethodArgumentNotValidException exe) {
//		ResponseError error = new ResponseError();
//
//		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
//		error.setMessage(exe.getLocalizedMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
//
//	}
//
//	@ExceptionHandler
//	public ResponseEntity<?> handleException(ParseException exe) {
//		ResponseError error = new ResponseError();
//
//		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
//		error.setMessage(exe.getLocalizedMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
//
//	}

}

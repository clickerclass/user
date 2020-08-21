package com.clickerclass.user.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clickerclass.user.exception.RestServiceException;

@ControllerAdvice
public class RestServiceExceptionControlador {
	@ExceptionHandler(value = RestServiceException.class)
	public ResponseEntity<Object> exception(RestServiceException exception) {

		return ResponseEntity.status(exception.getCodeResponse().intValue()).body(exception.getMessage());
	}
}

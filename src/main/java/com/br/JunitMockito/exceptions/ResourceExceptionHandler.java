package com.br.JunitMockito.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<StandardError> userNotFound(AppException ex, HttpServletRequest request) {
		StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI() + "id?="+request.getParameter("id"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}

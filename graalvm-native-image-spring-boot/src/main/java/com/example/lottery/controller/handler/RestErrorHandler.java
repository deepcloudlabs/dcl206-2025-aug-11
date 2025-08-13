package com.example.lottery.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.lottery.dto.error.RestErrorMessage;
import com.fasterxml.jackson.core.JacksonException;

@RestControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	public RestErrorMessage handleNullPointerException(NullPointerException e) {
		return new RestErrorMessage(e.getCause().getClass().getName(), e.getMessage());
	}
	
	@ExceptionHandler(JacksonException.class)
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	public RestErrorMessage handleJacksonException(JacksonException e) {
		return new RestErrorMessage(e.getCause().getClass().getName(), e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	public RestErrorMessage handleException(Exception e) {
		return new RestErrorMessage(e.getCause().getClass().getName(), e.getMessage());
	}
	
}

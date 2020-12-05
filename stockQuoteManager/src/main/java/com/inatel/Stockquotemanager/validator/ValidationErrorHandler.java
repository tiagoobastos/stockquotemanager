package com.inatel.Stockquotemanager.validator;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ErrorDTO handleIncorrectValue(NumberFormatException ex) {
		
		return new ErrorDTO("Value format error.", ex.getMessage()) ;
		
		
	}
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DateTimeParseException.class)
	public ErrorDTO handleIncorrectDate(DateTimeParseException ex) {
		return new ErrorDTO("Date format error.", ex.getMessage()) ;
		
	}
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidIDException.class)
	public ErrorDTO handleIncorrectID(InvalidIDException ex) {
		return new ErrorDTO("Incorrect ID error.", ex.getMessage()) ;
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ErrorDTO handleUnavailableStock(ValidationException ex) {
		
		return new ErrorDTO("Stock not found in stock manager.", ex.getMessage()) ;
		
		
	}

}

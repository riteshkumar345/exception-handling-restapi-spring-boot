package com.codex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	//  handle "Predefined Exception"; can access Globally
	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<ExceptionInfo> handleAE(ArithmeticException ae) {
		
		ExceptionInfo exception = new ExceptionInfo();
		exception.setMsg(ae.getMessage());
		exception.setCode("PRE.DEFINED.EXCEP.CODE.0001");
		
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//  handle "User Defined Exception";can access Globally
	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<ExceptionInfo> handleNoDataFoundError(NoDataFoundException ndfe) {
		
		ExceptionInfo excep = new ExceptionInfo();
		excep.setMsg(ndfe.getMessage());
		excep.setCode("USER.DEFINE.EXCEP.CODE.9999");
		
		return new ResponseEntity<>(excep, HttpStatus.BAD_REQUEST);
	}
 

}

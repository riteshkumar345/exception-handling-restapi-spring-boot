package com.codex.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codex.exception.ExceptionInfo;

@RestController
public class ControllerBasedExceptionHandling {
	
	Logger logger = LoggerFactory.getLogger(ControllerBasedExceptionHandling.class);
	
	@GetMapping("/status")
	public String getMsg() {
		
		String msg = "Work in progress";
		
		try {
			int i = 10/0;
		} catch(ArithmeticException ae) {
			// e.printStackTrace();
			
			/** Never use "printStackTrace(") as its print log msg only in server console which can't be accessible for everyone
			 *  Instead 1st log the message using logging framework like slf4j,log4j2, log-back etc.
			 *  Then re-throw the exception to User defined/Predefined exception class as shown below */
			
		    logger.error("Exception occured :: " +ae, ae);
		    throw new ArithmeticException(ae.getMessage());
		}
		
		return msg;
	}
	
	/**  handle "Predefined Exception" only for this class **/
	@ExceptionHandler(value = ArithmeticException.class)
	public ResponseEntity<ExceptionInfo> handleAE(ArithmeticException ae) {
		
		ExceptionInfo exception = new ExceptionInfo();
		exception.setMsg(ae.getMessage());
		exception.setCode("ABC0004");
		
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

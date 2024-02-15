package com.codex.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codex.exception.NoDataFoundException;

@RestController
public class GlobalBasedExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(GlobalBasedExceptionHandler.class);
	
	@GetMapping("/book/{isbn}")
	public String getBook(@PathVariable String isbn) {
		
		String msg = "";
		
		if(isbn.equals("ISBN001")) {
			msg = "Book Price is $ 48";
		} else {
			logger.error("Invalid ISBN");
			throw new NoDataFoundException("Invalid ISBN");
		}
		
		return msg;
	}

}

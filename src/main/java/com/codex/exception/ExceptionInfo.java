package com.codex.exception;

import lombok.Data;

/**
 *  This class is use to set and get custom/user defined "Exception Msg" with "Exception Code"
 */
@Data
public class ExceptionInfo {
	
	private String msg;
	private String code;

}

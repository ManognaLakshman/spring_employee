package com.nt.datarest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{
	private static final long serialVersionUID=100L;
}

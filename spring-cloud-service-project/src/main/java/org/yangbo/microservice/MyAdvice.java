package org.yangbo.microservice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class MyAdvice {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String exceptionAdvice(){
		return "/project";
	}
}

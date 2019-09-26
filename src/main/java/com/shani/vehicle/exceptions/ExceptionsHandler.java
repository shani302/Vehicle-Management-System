package com.shani.vehicle.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shani.vehicle.beans.ErrorBean;

@ControllerAdvice
public class ExceptionsHandler {
	
	@ResponseBody
	@ExceptionHandler
	public ErrorBean appExceptionHandler(Throwable throwable) {
		
		if(throwable instanceof ApplicationException) {
			
			ApplicationException exception = (ApplicationException) throwable;
			int internalErrorCode = exception.getErrorType().getErrorCode();
			String internalMessage = exception.getErrorType().getErrorMessage();
			String externalMessage = exception.getMessage();
			
			ErrorBean errorBean = new ErrorBean(internalErrorCode, internalMessage, externalMessage);
			if(exception.getErrorType().isCritcal()) {
				exception.printStackTrace();
			}
			
			return ResponseEntity.status(internalErrorCode).body(errorBean).getBody();
		}

		// error and untreated runTimeExceptions
		String internalMessage = throwable.getMessage();
		ErrorBean errorBean = new ErrorBean(601, internalMessage, "General Error");
		throwable.printStackTrace();
		
		return ResponseEntity.status(601).body(errorBean).getBody();
		
		
	}

}

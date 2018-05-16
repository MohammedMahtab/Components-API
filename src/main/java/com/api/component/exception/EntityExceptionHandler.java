package com.api.component.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.component.model.sdo.ExceptionErrorSDO;
import com.api.component.util.Consts;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
    public final ResponseEntity<Object> handleAnyException(Exception e) {
		ExceptionErrorSDO error = new ExceptionErrorSDO(HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage(),e.getMessage());
		return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler({ RequestParamException.class })
    public final ResponseEntity<Object> handleInvalidRequestParamException(Exception e) {
		ExceptionErrorSDO error = new ExceptionErrorSDO(Consts.COMPONENT_ERROR_CODE_1,Consts.COMPONENT__ERROR_REQ_MEG_DESC,
				Consts.COMPONENT__ERROR_RES_MEG);
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler({ ResponseException.class })
    public final ResponseEntity<Object> handleInvalidResponseException(Exception e) {
		ExceptionErrorSDO error = new ExceptionErrorSDO(Consts.COMPONENT__ERROR_CODE_2,Consts.COMPONENT__ERROR_RES_MEG_DESC,
				Consts.COMPONENT__ERROR_RES_MEG_DESC);
		return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

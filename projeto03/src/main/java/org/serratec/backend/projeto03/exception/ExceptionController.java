package org.serratec.backend.projeto03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value 
		      = {ClienteException.class })
	protected ResponseEntity<Object> naoEncontrado(ClienteException ex) {		
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
	       return buildResponseEntity(apiError);
	   }
	
	@ExceptionHandler(value 
		      = {CartaoException.class })
	protected ResponseEntity<Object> naoEncontrado(CartaoException ex) {		
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
	       return buildResponseEntity(apiError);
	   }
	
	@ExceptionHandler(value 
		      = {EmailException.class })
	protected ResponseEntity<Object> naoEncontrado(EmailException ex) {		
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
	       return buildResponseEntity(apiError);
	   }
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
}

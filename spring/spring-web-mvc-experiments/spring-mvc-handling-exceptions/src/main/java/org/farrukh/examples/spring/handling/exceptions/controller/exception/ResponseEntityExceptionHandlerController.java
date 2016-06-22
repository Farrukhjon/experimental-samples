/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.controller.exception;

import org.farrukh.examples.spring.handling.exceptions.dto.ErrorMessageDTO;
import org.farrukh.examples.spring.handling.exceptions.dto.ErrorMessageDTO.DetaliedMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler controller using ResponseEntityExceptionHandler methods.
 * Used instead of using @ExceptionHandler technique.
 * 
 * @author Farrukhjon SATTOROV
 *
 */
@ControllerAdvice
public class ResponseEntityExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessageDTO errorResponse = new ErrorMessageDTO();
		errorResponse.setStatusCode(status.value());
		errorResponse.setStatusMessage(ex.getMessage());
		errorResponse.setDetailedMessage(new DetaliedMessage(ex.getLocalizedMessage()));
		return new ResponseEntity<>(errorResponse, headers, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessageDTO errorResponse = new ErrorMessageDTO();
		errorResponse.setStatusCode(status.value());
		errorResponse.setStatusMessage(ex.getMessage());
		errorResponse.setDetailedMessage(new DetaliedMessage(ex.getLocalizedMessage()));
		return new ResponseEntity<>(errorResponse, headers, status);
	}


}

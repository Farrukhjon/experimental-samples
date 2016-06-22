/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler controller example.
 * 
 * @author Farrukhjon SATTOROV
 *
 */
@ControllerAdvice
public class GlobalExceptionHandlerController {

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ArithmeticException.class)
	public String handleConflict(ArithmeticException ex) {
		return ex.getMessage();
	}

}

/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.controller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple example of the controller based exception handler.
 * @author Farrukhjon SATTOROV
 *
 */

@RestController
@RequestMapping("/exceptions")
public class ControllerBasedExceptionHandlerController {

	@RequestMapping("/throw")
	public String getHello(){
		throw new RuntimeException("I am from getHello request method");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionHandler(RuntimeException exception){
		return exception.getMessage();
	}
	
}

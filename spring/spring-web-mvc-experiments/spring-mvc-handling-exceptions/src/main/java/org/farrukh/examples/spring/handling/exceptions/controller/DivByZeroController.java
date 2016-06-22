/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Global exception handler controller example.
 * @author Farrukhjon SATTOROV
 *
 */
@RestController
public class DivByZeroController {
	
	@RequestMapping("/divbyzero")
	public Double divide() {
		double result = 1/0;
		return result;
	}

}

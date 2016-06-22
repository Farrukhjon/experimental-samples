/**
 * 
 */
package org.examples.spring.rest.service.demo.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
public class RequestMappingFallbackMethod {

	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod() {
		return "Hello, I am falback method, unfortunately";
	}

}

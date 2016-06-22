/**
 * 
 */
package org.examples.spring.rest.service.demo.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
public class RequestMappingWithHTTPMethods {

	@RequestMapping(value = "/GET", method = RequestMethod.GET)
	@ResponseBody
	public String getMethod() {
		return "GET";
	}

	@RequestMapping(value = "/POST/{data}", method = RequestMethod.POST)
	@ResponseBody
	public String postMethod(@RequestParam("data") String data) {
		String postResult = new String(data);
		return "200"+ postResult;
	}

}

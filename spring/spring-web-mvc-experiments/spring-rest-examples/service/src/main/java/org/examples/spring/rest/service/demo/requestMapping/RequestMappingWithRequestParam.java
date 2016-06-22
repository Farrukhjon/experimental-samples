/**
 * 
 */
package org.examples.spring.rest.service.demo.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
public class RequestMappingWithRequestParam {

	@RequestMapping("/methodWithRequestParam")
	@ResponseBody
	public String methodWithParam(@RequestParam("paramData") String paramData) {
		return paramData;
	}

}

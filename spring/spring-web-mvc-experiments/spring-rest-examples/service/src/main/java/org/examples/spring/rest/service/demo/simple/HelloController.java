/**
 * 
 */
package org.examples.spring.rest.service.demo.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@RequestMapping("/{path}")
	@ResponseBody
	public String helloByPath(@PathVariable String path) {
		return "this from " + path;
	}

}

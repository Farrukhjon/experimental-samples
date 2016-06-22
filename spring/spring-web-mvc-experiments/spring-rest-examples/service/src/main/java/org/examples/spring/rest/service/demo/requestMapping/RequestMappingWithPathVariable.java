/**
 * 
 */
package org.examples.spring.rest.service.demo.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
public class RequestMappingWithPathVariable {

	@RequestMapping("/method7/{id}")
	@ResponseBody
	public String method7(@PathVariable("id") int id) {
		return "method7 with id=" + id;
	}

	@RequestMapping(value = "/method8/{id:[\\d]+}/{name}")
	@ResponseBody
	public String method8(@PathVariable("id") long id, @PathVariable("name") String name) {
		return "method8 with id= " + id + " and name=" + name;
	}

}

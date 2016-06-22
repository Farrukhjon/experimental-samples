/**
 * 
 */
package org.examples.spring.rest.service.demo.httpEntity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Controller
@RequestMapping("/entity")
public class HttpEntityContoller {

	@RequestMapping("/entity/{id}")
	public HttpEntity<String> getStatusCodeInfo(@RequestParam("id") int id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		if (isBetween(id, 100, 199))
			return new HttpEntity<>("Informational", responseHeaders);
		if (isBetween(id, 200, 299))
			return new HttpEntity<>("Success", responseHeaders);
		if (isBetween(id, 300, 399))
			return new HttpEntity<>("Redirection", responseHeaders);
		if (isBetween(id, 400, 499))
			return new HttpEntity<>("Client error", responseHeaders);
		if (isBetween(id, 500, 599))
			return new HttpEntity<>("Server error", responseHeaders);
		return new HttpEntity<>("", responseHeaders);
	}

	public static boolean isBetween(int id, int lower, int upper) {
		return lower <= id && id <= upper;
	}

}

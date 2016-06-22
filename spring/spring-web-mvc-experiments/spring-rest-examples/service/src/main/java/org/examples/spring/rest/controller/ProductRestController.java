/**
 * 
 */
package org.examples.spring.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.examples.spring.rest.dto.Product;
import org.examples.spring.rest.dto.ProductResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@RestController
@RequestMapping("/products")
public class ProductRestController implements IProductRestController {

	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<ProductResponse> getProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		List<Product> products = Arrays.asList(new Product(1, "Apple"), new Product(2, "Orange"), new Product(3, "Banana"));
		ProductResponse response = new ProductResponse();
		response.setRoducts(products);
		response.setStatusCode(1);
		response.setStatusMessage("Success");
		response.setDetailedMessage("");
		return new ResponseEntity<ProductResponse>(response, headers, HttpStatus.OK);
	}

}

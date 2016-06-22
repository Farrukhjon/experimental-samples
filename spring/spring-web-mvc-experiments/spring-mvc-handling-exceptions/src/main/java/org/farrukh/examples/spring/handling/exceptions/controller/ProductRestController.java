/**
 * 
 */
package org.farrukh.examples.spring.handling.exceptions.controller;

import org.farrukh.examples.spring.handling.exceptions.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Simple 'toy' controller
 * 
 * @author Farrukhjon SATTOROV
 *
 */

@RestController
@RequestMapping(value = "/products", produces = ProductDTO.JSON_CONTENT_TYPE, consumes = ProductDTO.JSON_CONTENT_TYPE)
public class ProductRestController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductDTO getProductById(@PathVariable int id) {
		return new ProductDTO(id, "computer");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ProductDTO getProduct(@RequestBody ProductDTO product) {
		product.setId(product.getId() + 1);
		return product;
	}

}

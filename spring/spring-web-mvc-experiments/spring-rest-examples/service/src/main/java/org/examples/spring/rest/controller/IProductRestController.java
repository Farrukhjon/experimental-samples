/**
 * 
 */
package org.examples.spring.rest.controller;

import org.examples.spring.rest.dto.ProductResponse;
import org.springframework.http.HttpEntity;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public interface IProductRestController {
	
	public HttpEntity<ProductResponse> getProducts();

}

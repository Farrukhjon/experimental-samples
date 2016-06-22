/**
 * 
 */
package org.examples.spring.boot.amqp.handler;

import org.examples.spring.boot.amqp.dto.ProductRequest;
import org.examples.spring.boot.amqp.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductHandler {

	@Autowired
	private ProductHandlerService productService;
	
	public ProductResponse handleMessage(ProductRequest request) {
		ProductResponse response = null;
		if(request != null){
			response = productService.getProductByPrice();
		}
		return response;
	}

}

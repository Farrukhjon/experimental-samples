/**
 * 
 */
package org.examples.spring.boot.amqp.handler;

import java.util.ArrayList;
import java.util.List;

import org.examples.spring.boot.amqp.dto.Product;
import org.examples.spring.boot.amqp.dto.ProductResponse;
import org.springframework.stereotype.Service;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Service
public class ProductHandlerService {

	public ProductResponse getProductByPrice() {
		ProductResponse productResponse = new ProductResponse();
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Laptop"));
		products.add(new Product(2, "Printer"));
		products.add(new Product(3, "Modem"));
		productResponse.setProducts(products);
		return productResponse;
	}
}

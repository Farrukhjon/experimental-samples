/**
 * 
 */
package org.examples.service;

import java.util.List;

import org.examples.dao.ProductMapper;
import org.examples.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Farrukhjon SATTOROV
 *
 */

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public List<Product> getProducts() {
		return null;
	}

	public Product getProductById(int id) {
		return productMapper.findOne(id);
	}

	public void saveProduct(Product entity) {
		productMapper.save(entity);
	}

}

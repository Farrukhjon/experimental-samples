/**
 * 
 */
package org.examples.mybatis.hsqldb.service;

import java.util.List;

import org.examples.mybatis.hsqldb.dao.ProductDao;
import org.examples.mybatis.hsqldb.dto.Product;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductService {
	
	private ProductDao productDao;
	
	public List<Product> findProducts(){
		return productDao.selectProducts();
	}
}

/**
 * 
 */
package org.examples.mybatis.hsqldb.dao;

import java.util.List;

import org.examples.mybatis.hsqldb.dto.Product;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public interface ProductDao {

	public List<Product> selectProducts();
	
}

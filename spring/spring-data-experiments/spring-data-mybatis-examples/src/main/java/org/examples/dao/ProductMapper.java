/**
 * 
 */
package org.examples.dao;

import org.examples.dto.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public interface ProductMapper extends CrudRepository<Product, Integer> {

}

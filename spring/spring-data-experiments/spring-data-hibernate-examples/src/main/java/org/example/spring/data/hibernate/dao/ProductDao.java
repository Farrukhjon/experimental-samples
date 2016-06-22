/**
 * 
 */
package org.example.spring.data.hibernate.dao;

import org.example.spring.data.hibernate.dto.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

}

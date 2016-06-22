/**
 * 
 */
package org.farrukh.examples.spring.data.rest.mongodb.repository;

import org.farrukh.examples.spring.data.rest.mongodb.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepository extends MongoRepository<Product, String>{

}

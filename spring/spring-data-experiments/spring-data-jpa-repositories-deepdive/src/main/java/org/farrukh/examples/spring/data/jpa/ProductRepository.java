/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface to access {@link Product}s.
 * 
 * @author Oliver Gierke
 */
public interface ProductRepository extends ReadOnlyRepository<Product>, ProductRepositoryCustom {

	/**
	 * Returns a {@link Page} of {@link Product}s having a description which contains the given snippet.
	 * 
	 * @param description
	 * @param pageable
	 * @return
	 */
	Page<Product> findByDescriptionContaining(String description, Pageable pageable);

	/**
	 * Returns all {@link Product}s having the given attribute.
	 * 
	 * @param attribute
	 * @return
	 */
	@Query("select p from Product p where p.attributes[?1] = ?2")
	List<Product> findByAttributeAndValue(String attribute, String value);
}

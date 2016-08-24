/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Repository} to access {@link Customer} instances.
 * 
 * @author Oliver Gierke
 * @since Step 2
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>,
		QueryDslPredicateExecutor<Customer> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	List<Customer> findAll();

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@Transactional(timeout = 10)
	<S extends Customer> S save(S entity);

	/**
	 * Returns the customer with the given {@link EmailAddress}.
	 * 
	 * @param emailAddress the {@link EmailAddress} to search for.
	 * @since Step 2
	 * @return
	 */
	Customer findByEmailAddress(EmailAddress emailAddress);
}

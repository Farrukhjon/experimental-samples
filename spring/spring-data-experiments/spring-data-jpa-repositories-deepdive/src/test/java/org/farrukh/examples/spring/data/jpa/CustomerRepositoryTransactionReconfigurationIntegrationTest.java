/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration test to show customized transaction configuration in {@link CustomerRepository}.
 * 
 * @since Step 5.2
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
@DirtiesContext
public class CustomerRepositoryTransactionReconfigurationIntegrationTest {

	@Autowired CustomerRepository repository;

	/**
	 * @since Step 5.2
	 */
	@Test
	public void executesRedeclaredMethodWithCustomTransactionConfiguration() {

		Customer customer = new Customer("Dave", "Matthews");
		Customer result = repository.save(customer);

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(notNullValue()));
		assertThat(result.getFirstname(), is("Dave"));
		assertThat(result.getLastname(), is("Matthews"));
	}
}

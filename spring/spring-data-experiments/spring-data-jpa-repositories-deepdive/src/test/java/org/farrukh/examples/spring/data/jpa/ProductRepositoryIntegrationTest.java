/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Integration tests for {@link ProductRepository}.
 * 
 * @author Oliver Gierke
 * @since Step 6
 */
public class ProductRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired ProductRepository repository;

	/**
	 * @since Step 6.1
	 */
	@Test
	public void findsAllProducts() {

		List<Product> products = repository.findAll();
		assertThat(products, hasSize(3));
	}

	/**
	 * @since Step 6.2
	 */
	@Test
	public void findsAllAppleProductPaged() {

		Page<Product> products = repository.findByDescriptionContaining("Apple", new PageRequest(0, 1));

		assertThat(products.isFirst(), is(true));
		assertThat(products.hasNext(), is(true));
		assertThat(products, Matchers.<Product> hasItem(hasProperty("name", is("iPad"))));
		assertThat(products, not(Matchers.<Product> hasItem(hasProperty("name", is("Dock")))));
	}

	/**
	 * @since Step 6.3
	 */
	@Test
	public void returnsOptionalEmptyForNonExistingProduct() {

		Optional<Product> result = repository.findOne(4711L);
		assertThat(result, is(Optional.empty()));
	}
	
	/**
	 * @since Step 7
	 */
	@Test
	public void executesManuallyDeclaredQuery() {

		List<Product> products = repository.findByAttributeAndValue("connector", "plug");

		assertThat(products, Matchers.<Product> hasItem(hasProperty("name", is("Dock"))));
	}

	/**
	 * @since Step 9
	 */
	@Test
	public void executesCustomlyImplementedMethod() {

		repository.removeProductsMoreExpensiveThan(new BigDecimal(500));

		List<Product> result = repository.findAll();

		assertThat(result, hasSize(2));
		assertThat(result, not(Matchers.<Product> hasItem(hasProperty("name", is("Mac Book Pro")))));
	}
}

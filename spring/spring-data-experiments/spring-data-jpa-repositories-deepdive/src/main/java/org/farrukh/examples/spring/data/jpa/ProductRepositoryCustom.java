/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import java.math.BigDecimal;

/**
 * Interface for data access code to be implemented manually.
 * 
 * @author Oliver Gierke
 */
interface ProductRepositoryCustom {

	/**
	 * Removes all {@link Product}s with a price greater than the given one.
	 * 
	 * @param price
	 */
	void removeProductsMoreExpensiveThan(BigDecimal price);
}

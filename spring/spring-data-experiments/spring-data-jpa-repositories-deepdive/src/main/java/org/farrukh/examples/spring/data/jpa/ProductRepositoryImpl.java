/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import java.math.BigDecimal;

import de.olivergierke.deepdive.QProduct;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Custom implementation class to implement {@link ProductRepositoryCustom}. Using the Querydsl repository base class.
 * 
 * @author Oliver Gierke
 */
public class ProductRepositoryImpl extends QueryDslRepositorySupport implements ProductRepositoryCustom {

	private static final QProduct product = QProduct.product;

	/**
	 * Creates a new instance of {@link ProductRepositoryImpl}.
	 */
	public ProductRepositoryImpl() {
		super(Product.class);
	}

	/* 
	 * (non-Javadoc)
	 * @see ProductRepositoryCustom#removeProductsMoreExpensiveThan(java.math.BigDecimal)
	 */
	@Override
	public void removeProductsMoreExpensiveThan(BigDecimal price) {
		delete(product).where(product.price.gt(price)).execute();
	}
}

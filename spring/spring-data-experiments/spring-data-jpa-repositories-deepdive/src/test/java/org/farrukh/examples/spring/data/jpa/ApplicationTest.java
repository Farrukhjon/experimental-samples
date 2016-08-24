/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Sample test case bootstrapping the application.
 * 
 * @author Oliver Gierke
 * @since Step 1
 */
public class ApplicationTest {

	@Test
	public void bootstrapsApplication() {
		new AnnotationConfigApplicationContext(ApplicationConfig.class).close();
	}
}

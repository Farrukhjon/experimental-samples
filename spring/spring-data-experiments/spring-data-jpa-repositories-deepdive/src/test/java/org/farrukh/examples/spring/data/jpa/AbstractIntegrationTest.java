/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract integration test to populate the database with dummy data.
 * 
 * @author Oliver Gierke
 * @since Step 1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public abstract class AbstractIntegrationTest {

}

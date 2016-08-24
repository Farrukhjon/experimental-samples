/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.farrukh.examples.jooq.datasource.MySQLDataSourceProvider;
import org.jooq.DSLContext;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DSLContextProviderTests {

    @Test
    public void testIfDSLContextProperlyConfigured() throws Exception {
        DSLContextProvider contextProvider = new DSLContextProvider(new MySQLDataSourceProvider());
        DSLContext dslContext = contextProvider.dslContext();
        assertNotNull(dslContext);
    }

    @Test
    public void test1() throws Exception {


    }
}

/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.farrukh.examples.jooq.datasource.MySQLDataSourceProvider;
import org.junit.Test;

public class CRUDTests extends AbstractBaseTest {

    public CRUDTests() {
        super(new MySQLDataSourceProvider());
    }

    @Test
    public void test1() throws Exception {
    }
}

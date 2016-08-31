/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.farrukh.examples.jooq.datasource.DataSourceProvider;
import org.farrukh.examples.jooq.datasource.MySQLDataSourceProvider;
import org.jooq.DSLContext;

public abstract class AbstractBaseTest {

    private DSLContextProvider contextProvider;

    AbstractBaseTest() {
        this(new MySQLDataSourceProvider());
    }

    AbstractBaseTest(DataSourceProvider dataSourceProvider) {
        contextProvider = new DSLContextProvider(dataSourceProvider);
    }

    DSLContext create() {
        return contextProvider.dslContext();
    }

}

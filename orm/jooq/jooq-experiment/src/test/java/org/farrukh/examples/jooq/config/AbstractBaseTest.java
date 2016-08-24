/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.farrukh.examples.jooq.datasource.DataSourceProvider;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public abstract class AbstractBaseTest {

    private final DataSourceProvider dataSourceProvider;

    public AbstractBaseTest(final DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    DSLContext create() {
        return DSL.using(this.dataSourceProvider.dataSource(), dataSourceProvider.dialect());
    }

}

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

public class DSLContextProvider {

    private final DataSourceProvider dataSourceProvider;

    public DSLContextProvider(final DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    public DSLContext dslContext() {
        return DSL.using(dataSourceProvider.dataSource(), dataSourceProvider.dialect());
    }

}

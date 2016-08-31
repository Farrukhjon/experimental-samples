/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.config;

import org.farrukh.examples.jooq.datasource.DataSourceProvider;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

public class DSLContextProvider {

    private final DataSourceProvider dataSourceProvider;

    public DSLContextProvider(final DataSourceProvider dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    public DSLContext dslContext() {
        Settings settings = new Settings();
        settings.setExecuteLogging(true);
        Configuration config = new DefaultConfiguration();
        config.set(dataSourceProvider.dataSource());
        config.set(dataSourceProvider.dialect());
        config.set(settings);
        return DSL.using(config);
    }

}

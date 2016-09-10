/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.datasource;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.dialect.H2Dialect;

import javax.sql.DataSource;

public class H2DataSourceProvider implements DataSourceProvider {

    // To keep the content of an in-memory database as long as the virtual machine is alive,
    // use jdbc:h2:mem:test;DB_CLOSE_DELAY=-1.

    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "";

    @Override
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(URL);
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Override
    public String dialect() {
        return H2Dialect.class.getName();
    }

}

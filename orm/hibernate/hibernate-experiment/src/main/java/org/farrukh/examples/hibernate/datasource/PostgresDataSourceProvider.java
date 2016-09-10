/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.hibernate.datasource;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresDataSourceProvider implements DataSourceProvider {

    private static final String URL = "jdbc:postgresql://localhost:5432/testdb";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "sa";

    @Override
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(URL);
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Override
    public String dialect() {
        return PostgreSQL94Dialect.class.getName();
    }
}

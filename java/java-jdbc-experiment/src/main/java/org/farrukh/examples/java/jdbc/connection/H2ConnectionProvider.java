/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.jdbc.connection;

import org.farrukh.examples.java.jdbc.datasource.H2DataSourceProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class H2ConnectionProvider implements ConnectionProvider {

    private final H2DataSourceProvider dataSourceProvider;

    public H2ConnectionProvider() {
        this.dataSourceProvider = new H2DataSourceProvider();
    }

    @Override
    public Connection openConnection() {
        DataSource dataSource = dataSourceProvider.dataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void closeConnection() {

    }

}

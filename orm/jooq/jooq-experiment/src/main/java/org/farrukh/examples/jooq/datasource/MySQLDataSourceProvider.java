/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.jooq.datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.jooq.SQLDialect;

import javax.sql.DataSource;

public class MySQLDataSourceProvider implements DataSourceProvider {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "sa";
    //private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    @Override
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Override
    public SQLDialect dialect() {
        return SQLDialect.MYSQL;
    }

}

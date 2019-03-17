package org.farrukh.experiments.money.datasource;

import org.hsqldb.jdbc.JDBCDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class HsqlDbConnectionFactoryImpl implements ConnectionFactory {

    private final String URL = "jdbc:hsqldb:hsql:mem:~/account_db";

    private final DataSource dataSource;

    public HsqlDbConnectionFactoryImpl() {
        dataSource = new JDBCDataSource();
        ((JDBCDataSource) dataSource).setURL(URL);

    }


    @Override
    public Connection newConnection() throws SQLException {
        return dataSource.getConnection();
    }

}

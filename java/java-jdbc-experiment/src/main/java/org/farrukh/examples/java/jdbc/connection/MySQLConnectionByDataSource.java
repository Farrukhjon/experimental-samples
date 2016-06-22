package org.farrukh.examples.java.jdbc.connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class MySQLConnectionByDataSource extends BaseMySQLConnection {

    public Connection getConnectionUsingDataSource() {
        Connection connection = null;
        try {
            connection = initDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private DataSource initDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        Properties properties = load();
        dataSource.setURL(properties.getProperty("MYSQL_URL"));
        dataSource.setUser(properties.getProperty("MYSQL_USERNAME"));
        dataSource.setPassword(properties.getProperty("MYSQL_PASSWORD"));
        return dataSource;
    }
}

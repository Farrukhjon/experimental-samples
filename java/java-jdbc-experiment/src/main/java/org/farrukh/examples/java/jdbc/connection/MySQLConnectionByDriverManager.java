package org.farrukh.examples.java.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class MySQLConnectionByDriverManager extends BaseMySQLConnection {

    private static final String MYSQL_FULL_URL = "jdbc:mysql://localhost:3306/testdb?user=root&password=sa";

    private MySQLConnectionByDriverManager() {
    }

    public Connection getConnectionUsingDriverManager() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(MYSQL_FULL_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

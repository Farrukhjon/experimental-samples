package org.farrukh.examples.java.jdbc.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public class PreparedStatementExamples {

    private final Connection connection;

    public PreparedStatementExamples(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement preparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}

/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.jdbc.transaction;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TransactionExperiment {

    public static void main(String[] args) {
        Runnable write = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeEmployee();
        };


        Runnable read = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readEmployee();
        };

        for (int i = 0; i < 10; i++) {
            Thread writer = new Thread(write);
            Thread reader = new Thread(read);
            writer.start();
            reader.start();
        }

    }

    private static synchronized void readEmployee() {
        System.out.printf("%s %s", Thread.currentThread().getName(), "Reading...\n");
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            connection.setAutoCommit(false);
            String select = "SELECT * FROM employee";
            PreparedStatement statement = connection.prepareStatement(select);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                int salary = rs.getInt(3);
                System.out.printf("\n%s %s", name, salary);
            }
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static synchronized void writeEmployee() {
        System.out.printf("%s %s", Thread.currentThread().getName(), "Writing...\n");
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            connection.setAutoCommit(false);
            String insert = "INSERT INTO employee(name, salary) VALUE(?, ?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            String randomName = UUID.randomUUID().toString().substring(0, 7);
            int randomSalary = new Random().ints(1000, 10000).findFirst().getAsInt();
            statement.setString(1, randomName);
            statement.setInt(2, randomSalary);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static class ConnectionManager {

        private static final String URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
        private static final String DB_NAME = "testdb";
        private static final String USER = "root";
        private static final String PASSWORD = "sa";

        private static DataSource getDataSource() {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(URL);
            dataSource.setDatabaseName(DB_NAME);
            dataSource.setUser(USER);
            dataSource.setPassword(PASSWORD);
            return dataSource;
        }

        public static Connection getConnection() {
            Connection connection = null;
            try {
                connection = getDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

}
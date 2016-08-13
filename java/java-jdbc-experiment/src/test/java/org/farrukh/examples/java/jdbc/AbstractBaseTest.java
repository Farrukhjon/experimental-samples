/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.jdbc;

import org.farrukh.examples.java.jdbc.connection.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public abstract class AbstractBaseTest {

    private final ConnectionProvider connectionProvider;

    AbstractBaseTest(final ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    final void doInTx(Consumer<Connection> consumer) {
        Connection connection = connectionProvider.openConnection();
        try {
            connection.setAutoCommit(false);
            consumer.accept(connection);
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
                throw e;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

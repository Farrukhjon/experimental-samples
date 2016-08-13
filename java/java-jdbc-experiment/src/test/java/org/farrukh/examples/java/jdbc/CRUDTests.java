/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.java.jdbc;

import org.farrukh.examples.java.jdbc.connection.H2ConnectionProvider;
import org.junit.Assert;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDTests extends AbstractBaseTest {

    public CRUDTests() {
        super(new H2ConnectionProvider());
    }

    @Test
    public void shouldQueryVersionOfH2Database() throws Exception {
        doInTx(connection -> {
            String expectedVersion = "1.4.192";
            String sql = "SELECT H2VERSION() FROM DUAL";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String result = rs.getString(1);
                    Assert.assertEquals(expectedVersion, result);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}

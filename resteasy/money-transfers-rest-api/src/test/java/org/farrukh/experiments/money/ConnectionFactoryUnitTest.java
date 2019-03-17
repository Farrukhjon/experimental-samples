package org.farrukh.experiments.money;

import org.farrukh.experiments.money.datasource.ConnectionFactory;
import org.farrukh.experiments.money.datasource.HsqlDbConnectionFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryUnitTest {

    @Test
    public void testHsqlDb() throws SQLException {

        ConnectionFactory connectionFactory = new HsqlDbConnectionFactoryImpl();
        Connection connection = connectionFactory.newConnection();

        Assert.assertNotNull(connection);
    }
}

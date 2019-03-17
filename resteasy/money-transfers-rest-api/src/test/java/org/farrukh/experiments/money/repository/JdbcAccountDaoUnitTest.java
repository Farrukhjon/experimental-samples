package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.repository.AccountDao;
import org.farrukh.experiments.money.repository.JdbcAccountDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JdbcAccountDaoUnitTest {

    AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        accountDao = new JdbcAccountDaoImpl();
    }

    @Test
    public void testAccountDao() {
        Assert.assertNotNull(accountDao);
    }
}

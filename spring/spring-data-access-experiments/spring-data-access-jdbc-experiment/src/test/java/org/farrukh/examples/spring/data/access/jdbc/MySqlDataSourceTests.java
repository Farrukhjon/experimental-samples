package org.farrukh.examples.spring.data.access.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@ActiveProfiles("production")
@RunWith(SpringJUnit4ClassRunner.class)
public class MySqlDataSourceTests extends BaseTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testH2DataSource() {
        Assert.assertNotNull(dataSource);
    }

}

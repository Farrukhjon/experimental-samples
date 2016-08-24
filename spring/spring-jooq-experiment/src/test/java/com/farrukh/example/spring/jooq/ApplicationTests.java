package com.farrukh.example.spring.jooq;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    DSLContext create;

    @Autowired
    DataSource dataSource;

    @Test
    public void testInitObjects() {
        assertNotNull(dataSource);
        assertNotNull(create);
    }

    @Test
    public void test1() throws Exception {

    }
}

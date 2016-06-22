package org.farrukh.examples.spring.data.access.jdbc;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class SimpleJdbcCallTests extends BaseTest {

    @Autowired
    private SimpleJdbcCall simpleJdbcCall;

    @Test
    public void test() {
        Assert.assertNotNull(simpleJdbcCall);
    }

}

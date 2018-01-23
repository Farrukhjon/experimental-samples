package org.farrukh.experiments.spring;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:trading-context.xml")
public class SpringJdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Before
    public void setUp() throws Exception {
        loadTestDataToDb();
    }


    @Test
    @Transactional
    @Rollback
    public void test() {
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList("select * from TRADE");
        for (Map<String, Object> result : resultSet) {
            System.out.println(result);
        }
    }

    private void loadTestDataToDb() {
        SimpleJdbcTestUtils.executeSqlScript(new SimpleJdbcTemplate(jdbcTemplate), new ClassPathResource("script.sql"), false);
    }


}

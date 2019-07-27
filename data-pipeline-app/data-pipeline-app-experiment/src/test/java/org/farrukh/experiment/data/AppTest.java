package org.farrukh.experiment.data;


import org.cassandraunit.spring.CassandraUnitDependencyInjectionIntegrationTestExecutionListener;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.CassandraUnitTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@EmbeddedCassandra
@TestExecutionListeners(listeners = {
        CassandraUnitTestExecutionListener.class,
        CassandraUnitDependencyInjectionTestExecutionListener.class,
        CassandraUnitDependencyInjectionIntegrationTestExecutionListener.class
})
public class AppTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void test() {

    }

}

package org.farrukh.experiments.spring.batch.xml;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class BaseSpringBatchComponentsTest extends AbstractBaseXMLConfigTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    PlatformTransactionManager txManager;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobLauncherTestUtils launcher;

    @Test
    public void testName() throws Exception {
        assertNotNull(dataSource);
        assertNotNull(txManager);
        assertNotNull(jobRepository);
    }

}

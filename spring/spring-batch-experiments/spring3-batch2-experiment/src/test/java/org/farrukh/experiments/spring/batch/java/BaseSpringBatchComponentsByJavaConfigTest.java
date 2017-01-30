package org.farrukh.experiments.spring.batch.java;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class BaseSpringBatchComponentsByJavaConfigTest extends AbstractBaseJavaConfigTest {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobRegistry jobRegistry;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Test
    public void testMainSpringBatchComponentsInjection() throws Exception {
        assertNotNull(jobBuilderFactory);
        assertNotNull(stepBuilderFactory);

        assertNotNull(jobRegistry);
        assertNotNull(jobRepository);
        assertNotNull(jobLauncher);
    
        assertNotNull(jobLauncherTest);
    }

}

package org.farrukh.experiments.spring.batch.java;

import org.farrukh.experiments.spring.batch.config.BatchJobContextJavaConfiguration;
import org.junit.runner.RunWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BatchJobContextJavaConfiguration.class, JobLauncherTestContextConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractBaseJavaConfigTest {

    @Autowired
    JobLauncherTestUtils jobLauncherTest;

}

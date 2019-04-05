package org.farrukh.experiments;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class AppTest {


    @Autowired
    private JobLauncherTestUtils jobLauncherTest;


    @Before
    public void setUp() throws Exception {
        assertNotNull(jobLauncherTest);
    }

    @Test
    public void testAppJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobName", "appJob")
                .toJobParameters();
        jobLauncherTest.launchJob(jobParameters);
    }


}

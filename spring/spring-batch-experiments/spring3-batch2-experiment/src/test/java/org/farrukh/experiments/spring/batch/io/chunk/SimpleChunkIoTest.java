package org.farrukh.experiments.spring.batch.io.chunk;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/jobs/simple-chunk-io-job.xml", "/job-launcher-test-config.xml" })
public class SimpleChunkIoTest {
    
    @Autowired
    JobLauncherTestUtils jobLauncher;
    
    @Test
    public void testSimpleChunkIO() throws Exception {
        Map<String, JobParameter> parameters = new HashMap<String, JobParameter>();
        parameters.put("commit.interval", new JobParameter("5"));
        
        JobExecution jobExecution = jobLauncher.launchJob(new JobParameters(parameters));
        
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

}

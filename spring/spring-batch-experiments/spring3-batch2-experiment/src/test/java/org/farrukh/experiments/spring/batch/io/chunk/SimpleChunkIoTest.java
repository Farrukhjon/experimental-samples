package org.farrukh.experiments.spring.batch.io.chunk;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
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
        JobExecution jobExecution = jobLauncher.launchJob();
        
        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }

}

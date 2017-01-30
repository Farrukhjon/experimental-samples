package org.farrukh.experiments.spring.batch.java;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;

public class DocsHandlingJobTest extends AbstractBaseJavaConfigTest {
    
    @Test
    public void testJob() throws Exception {
        JobExecution launchJob = jobLauncherTest.launchJob();
        BatchStatus status = launchJob.getStatus();
        Assert.assertEquals(BatchStatus.COMPLETED, status);
    }

}

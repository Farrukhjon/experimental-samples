package org.farrukh.experiments.spring.batch.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class JobTest extends AbstractBaseXMLConfigTest {

    @Autowired
    JobLauncherTestUtils launcher;

    @Test
    public void launchJob1() throws Exception {
        JobExecution jobLauncher = launcher.launchJob();
        BatchStatus status = jobLauncher.getStatus();

        assertEquals(BatchStatus.COMPLETED, status);
    }

}

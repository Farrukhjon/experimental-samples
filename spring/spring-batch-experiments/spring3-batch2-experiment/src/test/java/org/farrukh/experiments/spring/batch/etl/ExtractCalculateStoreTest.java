package org.farrukh.experiments.spring.batch.etl;

import static org.junit.Assert.assertNotNull;

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
@ContextConfiguration({ "jobs/extract-calculate-store-job.xml", "job-launcher-test-config.xml" })
public class ExtractCalculateStoreTest {

    @Autowired
    JobLauncherTestUtils jobLancher;

    @Test
    public void testExtractCalculateStore() throws Exception {
        assertNotNull(jobLancher);

        Map<String, JobParameter> parameters = new HashMap<>();
        JobParameters jobParameters = new JobParameters(parameters);
        JobExecution jobExecuion = jobLancher.launchJob(jobParameters);

        Assert.assertEquals(BatchStatus.COMPLETED, jobExecuion.getStatus());
    }

}

package org.farrukh.experiments.spring.batch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job1;

	@Before
	public void setUp() throws Exception {
		assertNotNull(jobLauncher);
	}

	@Test
	public void shouldReadXmlProcessAndProduceCsvFile() throws Exception 	{
		jobLauncher.run(job1, new JobParameters());
	}

}


package org.farrukh.examples.spring.batch.simple

import org.farrukh.examples.spring.batch.BaseIntegrationTest
import org.springframework.batch.core.ExitStatus
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Autowired

class ExecuteSimpleBatchJob extends BaseIntegrationTest {

    @Autowired
    JobLauncher jobLauncher

    def 'should execute a simple batch job'() {
        when:
        def execution = jobLauncher.run(mySimpleJob, new JobParameters())
        def status = execution.exitStatus

        then:
        status == ExitStatus.COMPLETED
    }

}

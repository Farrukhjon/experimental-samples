package org.farrukh.experiments.spring.batch.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class GreetingTasklet implements Tasklet {
    
    static final Logger LOGGER = LoggerFactory.getLogger(GreetingTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        LOGGER.info("Task 1 is executed!");
        return RepeatStatus.FINISHED;
    }

}

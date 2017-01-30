package org.farrukh.examples.spring.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot based stand-alone application.
 */
@SuppressWarnings({"checkstyle:hideutilityclassconstructor", "checkstyle:constantname"})
@EnableBatchProcessing
@SpringBootApplication
public class Application {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @SuppressWarnings("checkstyle:javadocmethod")
    public static void main(final String[] args) {
        logger.info("Running entry point application");
        //SpringApplication.run(Application.class, args);
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    protected Tasklet tasklet() {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext context) {
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Job job() throws Exception {
        return this.jobs.get("job")
                        .start(step1())
                        .build();
    }

    @Bean
    protected Step step1() throws Exception {
        return this.steps.get("step1")
                         .tasklet(tasklet())
                         .build();
    }

}

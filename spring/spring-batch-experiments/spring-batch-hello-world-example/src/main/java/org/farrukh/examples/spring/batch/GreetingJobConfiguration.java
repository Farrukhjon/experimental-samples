package org.farrukh.examples.spring.batch;

import org.farrukh.examples.spring.batch.domain.Greeting;
import org.farrukh.examples.spring.batch.listener.LogProcessorListener;
import org.farrukh.examples.spring.batch.processor.GreetingItemProcessor;
import org.farrukh.examples.spring.batch.reader.GreetingFlatFileItemReader;
import org.farrukh.examples.spring.batch.writer.GreetingFlatFileItemWriter;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class GreetingJobConfiguration {

    @Bean
    public Job greetingJob(final JobBuilderFactory builderFactory, final Step greetingStep) {
        return builderFactory.get("greetingJob")
                             .start(greetingStep)
                             .build();
    }

    @Bean
    public Step greetingStep(final StepBuilderFactory stepBuilderFactory, final ItemReader<Greeting> greetingReader,
                             final ItemProcessor<Greeting, Greeting> greetingProcessor,
                             final ItemWriter<Greeting> greetingWriter,
                             final ItemProcessListener<Greeting, Greeting> logProcessorListener) {
        return stepBuilderFactory.get("greetingStep")
                                 .<Greeting, Greeting>chunk(1)
                                 .reader(greetingReader)
                                 .processor(greetingProcessor)
                                 .writer(greetingWriter)
                                 .listener(logProcessorListener)
                                 .build();
    }

    @Bean
    public ItemReader<Greeting> greetingReader() {
        return new GreetingFlatFileItemReader();
    }

    @Bean
    public ItemProcessor<Greeting, Greeting> greetingProcessor() {
        return new GreetingItemProcessor();
    }

    @Bean
    public ItemWriter<Greeting> greetingWriter() {
        return new GreetingFlatFileItemWriter();
    }

    @Bean
    public ItemProcessListener<Greeting, Greeting> logProcessorListener() {
        return new LogProcessorListener();
    }

}

package org.farrukh.experiments.spring.batch;

import org.farrukh.experiments.spring.batch.job.XmlItemReader;
import org.farrukh.experiments.spring.batch.job.XmlToCsvItemProcessor;
import org.farrukh.experiments.spring.batch.job.XmlToCsvItemWriter;
import org.farrukh.experiments.spring.batch.model.Csv;
import org.farrukh.experiments.spring.batch.model.Xml;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class Application {

    public static final String XML_TO_CSV_JOB_NAME = "xml_to_csv";

    @Bean
    public XmlItemReader xXmlItemReader(Jaxb2Marshaller jaxb2Marshaller) {
        return new XmlItemReader(jaxb2Marshaller);
    }

    @Bean
    public XmlToCsvItemProcessor xmlToCsvItemProcessor() {
        return new XmlToCsvItemProcessor();
    }

    @Bean
    public XmlToCsvItemWriter xmlToCsvItemWriter() {
        return new XmlToCsvItemWriter();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory,
                      XmlItemReader xmlItemReader, XmlToCsvItemProcessor xmlToCsvItemProcessor, XmlToCsvItemWriter xmlToCsvItemWriter) {
        return stepBuilderFactory
                .get(XML_TO_CSV_JOB_NAME)
                .<Xml, Csv>chunk(2)
                .reader(xmlItemReader)
                .processor(xmlToCsvItemProcessor)
                .writer(xmlToCsvItemWriter)
                .build();
    }

    @Bean
    public Job job1(JobBuilderFactory jobBuilderFactory, Step step1) {
        return jobBuilderFactory
                .get(XML_TO_CSV_JOB_NAME)
                .start(step1)
                .build();
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("org.farrukh.experiments.spring.batch.model");
        return jaxb2Marshaller;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


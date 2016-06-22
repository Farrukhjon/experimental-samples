package org.farrukh.examples.spring.data.mongodb;

import org.farrukh.examples.spring.data.mongodb.repository.PersonRepositoryAdvanced;
import org.farrukh.examples.spring.data.mongodb.repository.PersonRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PersonRepositoryAdvanced personRepositoryImpl(final MongoOperations mongoTemplate) {
        return new PersonRepositoryImpl(mongoTemplate);
    }

}

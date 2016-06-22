package org.farrukh.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

@EnableConfigurationProperties(CarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Validator configurationPropertiesValidator() {
        return new CarPropertiesValidator();
    }

    @Bean
    public CommandLineRunner startUp(final  CarProperties properties) {
        return (String... args) -> {
            System.out.println("=========================================");
            System.out.println("Car manufacturer: " + properties.getManufacturer());
            System.out.println("Car seat count: " + properties.getSeatCount());
            System.out.println("=========================================");
        };
    }

}

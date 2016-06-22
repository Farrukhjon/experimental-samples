package org.farrukh.examples.spring.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot based stand-alone application.
 */
@SuppressWarnings({"checkstyle:hideutilityclassconstructor", "checkstyle:constantname"})
@SpringBootApplication
public class Application {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @SuppressWarnings("checkstyle:javadocmethod")
    public static void main(final String[] args) {
        logger.info("Running entry point application");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CustomServiceLoader customService() {
        return new CustomServiceLoader();
    }

}

package org.farrukh.examples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
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
        new SpringApplicationBuilder().sources(Application.class)
                                      .run(args);
    }

    @Bean
    public ComponentA componentA() {
        return new ComponentA();
    }

    @Bean
    public ComponentB componentB() {
        return new ComponentB();
    }

    @Bean
    public ComponentC componentC() {
        return new ComponentC();
    }


}

package org.farrukh.examples.spring.mvc.content.negotiation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate()
    }
}

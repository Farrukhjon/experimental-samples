package org.farrukh.example.spring.jersey;

import org.farrukh.example.spring.jersey.outbound.PostProvider;
import org.farrukh.example.spring.jersey.outbound.PostProviderImpl;
import org.farrukh.example.spring.jersey.service.PostService;
import org.farrukh.example.spring.jersey.service.PostServiceImpl;
import org.farrukh.example.spring.jersey.repository.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {

    @Bean
    public RestOperations restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PostProvider postProvider(final RestOperations restTemplate) {
        return new PostProviderImpl(restTemplate);
    }

    @Bean
    public PostService postService(final PostProvider postProvider, final PostRepository repository) {
        return new PostServiceImpl(postProvider, repository);
    }

    /*public static void main(String[] args) {
        new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
    }
*/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

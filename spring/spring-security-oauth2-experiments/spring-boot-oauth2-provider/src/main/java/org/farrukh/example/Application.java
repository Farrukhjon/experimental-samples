package org.farrukh.example;

import org.farrukh.example.repository.UserRepository;
import org.farrukh.example.service.UserDetailsServiceImpl;
import org.farrukh.example.service.UserService;
import org.farrukh.example.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public UserService userService(final UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public UserDetailsService userDetailsService(final UserService userService) {
        return new UserDetailsServiceImpl(userService);
    }


}

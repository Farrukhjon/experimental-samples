package org.farrukh.examples.spring.security.jpa;

import org.farrukh.examples.spring.security.jpa.repository.UserRepository;
import org.farrukh.examples.spring.security.jpa.service.CustomUserDetailsService;
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
	public UserDetailsService userDetailsService(final UserRepository userRepository) {
		return new CustomUserDetailsService(userRepository);
	}

}

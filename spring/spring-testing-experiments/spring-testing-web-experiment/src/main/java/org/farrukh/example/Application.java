package org.farrukh.example;

import org.farrukh.example.service.UserService;
import org.farrukh.example.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

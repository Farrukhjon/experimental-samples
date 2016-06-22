package org.farrukh.examples.spring.data.access.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Profile("production")
@PropertySource("classpath:mysql.properties")
public class MySqlDataSourceConfig {

    @Bean
    public DataSource dataSource(Environment environment) {
        String url = environment.getProperty("mysql.url");
        String username = environment.getProperty("mysql.username");
        String password = environment.getProperty("mysql.password");
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
        dataSource.setDriverClassName(environment.getProperty("mysql.driverClassName"));
        return dataSource;
    }

}

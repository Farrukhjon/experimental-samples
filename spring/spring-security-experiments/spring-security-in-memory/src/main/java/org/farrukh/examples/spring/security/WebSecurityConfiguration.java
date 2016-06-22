package org.farrukh.examples.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .authorizeRequests()
                  .antMatchers("/", "/home", "/about", "/sign_up").permitAll()
                  .antMatchers(HttpMethod.GET, "/user/**").access("hasRole('USER')")
                  .antMatchers(HttpMethod.GET, "/client/**").access("hasRole('CLIENT')")
                  .antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                  .antMatchers(HttpMethod.GET, "/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                  .anyRequest().authenticated()
                .and().httpBasic();
        //@formatter:on
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("pwd").roles("USER")
                .and()
                .withUser("client").password("pwd").roles("CLIENT")
                .and()
                .withUser("admin").password("pwd").roles("ADMIN")
                .and()
                .withUser("db").password("pwd").roles("ADMIN", "DBA");
    }
}

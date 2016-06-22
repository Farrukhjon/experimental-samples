package org.farrukh.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                  .antMatchers("/*", "/home", "/sign_up", "/sign_in", "/login", "/logout", "/about").permitAll()
                  .antMatchers("/user/**").access("hasRole('USER')")
                  .antMatchers("/admin/**").hasRole("ADMIN")
                  .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                  .anyRequest().authenticated()
                .and()
                .httpBasic();
        // @formatter:on
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth
                .userDetailsService(userDetailsService)
                .and()
                .inMemoryAuthentication()
                  .withUser("test").password("pwd").roles("USER");
        // @formatter:on
    }

}

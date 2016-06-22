package org.farrukh.examples.spring.security.jpa.service;

import org.farrukh.examples.spring.security.jpa.domain.CustomUserDetails;
import org.farrukh.examples.spring.security.jpa.domain.User;
import org.farrukh.examples.spring.security.jpa.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(() ->
                                  new UsernameNotFoundException("Could not find the user " + username));
        return new CustomUserDetails(user);
    }

}

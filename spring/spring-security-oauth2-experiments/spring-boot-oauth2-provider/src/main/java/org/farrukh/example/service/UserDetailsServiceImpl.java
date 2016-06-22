package org.farrukh.example.service;

import org.farrukh.example.domain.CustomUserDetails;
import org.farrukh.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(username)
                              .orElseThrow(() -> new UsernameNotFoundException("Could not find the user " + username));
        return new CustomUserDetails(user);
    }

}

package com.dev.cinema.security;

import com.dev.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.dev.cinema.model.User user = userService.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user with such email"
                        + email));
        org.springframework.security.core.userdetails.User.UserBuilder builder =
                org.springframework.security.core.userdetails.User.builder();
        builder.username(user.getEmail());
        builder.password(user.getPassword());
        builder.authorities(user.getRoles().stream().map(e -> e.getRoleName()
                .name()).toArray(String[]::new));
        return builder.build();
    }
}

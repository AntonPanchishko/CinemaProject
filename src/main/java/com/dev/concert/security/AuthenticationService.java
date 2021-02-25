package com.dev.concert.security;

import com.dev.concert.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}

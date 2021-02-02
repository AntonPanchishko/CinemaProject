package com.dev.cinema.security;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.lib.Inject;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new AuthenticationException("Can't find user with such email " + email);
        }
        User userByEmail = userService.findByEmail(email).get();
        String passwordHashFromDB = userByEmail.getPassword();
        String hashOfInputPassword = HashUtil.getHashPassword(password, userByEmail.getSalt());
        if (passwordHashFromDB.equals(hashOfInputPassword)) {
            return userByEmail;
        }
        throw new AuthenticationException("Cant find user with such "
                + email + " and password " + password);
    }

    @Override
    public User register(String email, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        userService.add(newUser);
        return newUser;
    }
}

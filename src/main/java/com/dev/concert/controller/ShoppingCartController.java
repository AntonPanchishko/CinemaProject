package com.dev.concert.controller;

import com.dev.concert.model.ConcertSession;
import com.dev.concert.model.User;
import com.dev.concert.model.dto.response.ShoppingCartResponseDto;
import com.dev.concert.service.ConcertSessionService;
import com.dev.concert.service.ShoppingCartService;
import com.dev.concert.service.UserService;
import com.dev.concert.service.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ConcertSessionService concertSessionService;
    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ConcertSessionService concertSessionService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.concertSessionService = concertSessionService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping
    public void addSession(Authentication authentication, @RequestParam Long movieSessionId) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).get();
        ConcertSession concertSession = concertSessionService.get(movieSessionId);
        shoppingCartService.addSession(concertSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).get();
        return shoppingCartMapper.toDtoFromObject(shoppingCartService.getByUser(user));
    }
}

package com.dev.concert.service;

import com.dev.concert.model.ConcertSession;
import com.dev.concert.model.ShoppingCart;
import com.dev.concert.model.User;

public interface ShoppingCartService {
    void addSession(ConcertSession concertSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}

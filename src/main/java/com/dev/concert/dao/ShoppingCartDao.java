package com.dev.concert.dao;

import com.dev.concert.model.ShoppingCart;
import com.dev.concert.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}

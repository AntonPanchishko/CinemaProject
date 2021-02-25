package com.dev.concert.service;

import com.dev.concert.model.Order;
import com.dev.concert.model.ShoppingCart;
import com.dev.concert.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}

package com.dev.concert.dao;

import com.dev.concert.model.Order;
import com.dev.concert.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}

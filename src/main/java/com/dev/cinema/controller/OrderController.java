package com.dev.cinema.controller;

import com.dev.cinema.model.dto.response.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderMapper orderMapper,
                           UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        return orderService
                .getOrdersHistory(userService.getById(userId))
                .stream()
                .map(orderMapper::toDtoFromObject)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return orderMapper.toDtoFromObject(orderService
                .completeOrder(shoppingCartService.getByUser(userService.getById(userId))));
    }
}

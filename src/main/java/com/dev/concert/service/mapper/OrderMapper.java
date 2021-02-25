package com.dev.concert.service.mapper;

import com.dev.concert.model.Order;
import com.dev.concert.model.Ticket;
import com.dev.concert.model.dto.response.OrderResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toDtoFromObject(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDate(order.getOrderDate().toString());
        orderResponseDto.setEmail(order.getUser().getEmail());
        orderResponseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}

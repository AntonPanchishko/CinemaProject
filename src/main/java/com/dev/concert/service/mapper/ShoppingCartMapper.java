package com.dev.concert.service.mapper;

import com.dev.concert.model.ShoppingCart;
import com.dev.concert.model.Ticket;
import com.dev.concert.model.dto.response.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto toDtoFromObject(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto
                .setTicketIds(shoppingCart
                        .getTickets()
                        .stream()
                        .map(Ticket::getId)
                        .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}

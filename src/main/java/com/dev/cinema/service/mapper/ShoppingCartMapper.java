package com.dev.cinema.service.mapper;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.response.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
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

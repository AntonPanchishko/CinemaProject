package com.dev.concert.service.mapper;

import com.dev.concert.model.Concert;
import com.dev.concert.model.dto.request.ConcertRequestDto;
import com.dev.concert.model.dto.response.ConcertResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper {
    public Concert fromDtoToObject(ConcertRequestDto concertRequestDto) {
        Concert concert = new Concert();
        concert.setDescription(concertRequestDto.getDescription());
        concert.setTitle(concertRequestDto.getTitle());
        return concert;
    }

    public ConcertResponseDto toDtoFromObject(Concert concert) {
        ConcertResponseDto concertResponseDto = new ConcertResponseDto();
        concertResponseDto.setId(concert.getId());
        concertResponseDto.setDescription(concert.getDescription());
        concertResponseDto.setTitle(concert.getTitle());
        return concertResponseDto;
    }
}

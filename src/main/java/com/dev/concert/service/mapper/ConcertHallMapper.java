package com.dev.concert.service.mapper;

import com.dev.concert.model.ConcertHall;
import com.dev.concert.model.dto.request.ConcertHallRequestDto;
import com.dev.concert.model.dto.response.ConcertHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ConcertHallMapper {
    public ConcertHall fromDtoToObject(ConcertHallRequestDto concertHallRequestDto) {
        ConcertHall concertHall = new ConcertHall();
        concertHall.setDescription(concertHallRequestDto.getDescription());
        concertHall.setCapacity(concertHallRequestDto.getCapacity());
        return concertHall;
    }

    public ConcertHallResponseDto toDtoFromObject(ConcertHall concertHall) {
        ConcertHallResponseDto cinemaHallDto = new ConcertHallResponseDto();
        cinemaHallDto.setId(cinemaHallDto.getId());
        cinemaHallDto.setDescription(concertHall.getDescription());
        cinemaHallDto.setCapacity(concertHall.getCapacity());
        return cinemaHallDto;
    }
}

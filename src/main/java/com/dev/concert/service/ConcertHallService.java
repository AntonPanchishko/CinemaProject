package com.dev.concert.service;

import com.dev.concert.model.ConcertHall;
import java.util.List;

public interface ConcertHallService {
    ConcertHall add(ConcertHall concertHall);

    List<ConcertHall> getAll();

    ConcertHall get(Long cinemaHallId);
}

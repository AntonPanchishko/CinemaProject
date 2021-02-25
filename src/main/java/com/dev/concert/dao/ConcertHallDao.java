package com.dev.concert.dao;

import com.dev.concert.model.ConcertHall;
import java.util.List;
import java.util.Optional;

public interface ConcertHallDao {
    ConcertHall add(ConcertHall concertHall);

    List<ConcertHall> getAll();

    Optional<ConcertHall> getById(Long cinemaHallId);
}

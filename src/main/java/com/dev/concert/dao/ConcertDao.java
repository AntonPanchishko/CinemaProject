package com.dev.concert.dao;

import com.dev.concert.model.Concert;
import java.util.List;
import java.util.Optional;

public interface ConcertDao {
    Concert add(Concert concert);

    List<Concert> getAll();

    Optional<Concert> getById(Long movieId);
}

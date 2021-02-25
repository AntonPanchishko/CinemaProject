package com.dev.concert.service;

import com.dev.concert.model.Concert;
import java.util.List;

public interface ConcertService {
    Concert add(Concert concert);

    List<Concert> getAll();

    Concert get(Long movieId);
}

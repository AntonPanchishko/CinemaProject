package com.dev.cinema.service;

import com.dev.cinema.model.MovieSession;
import java.util.List;
import java.time.LocalDate;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);
}

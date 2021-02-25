package com.dev.concert.service;

import com.dev.concert.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;

public interface ConcertSessionService {
    List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date);

    ConcertSession add(ConcertSession concertSession);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);

    ConcertSession get(Long id);
}

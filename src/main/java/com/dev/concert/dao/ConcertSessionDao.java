package com.dev.concert.dao;

import com.dev.concert.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConcertSessionDao {
    List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date);

    ConcertSession add(ConcertSession concertSession);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);

    Optional<ConcertSession> getById(Long id);
}

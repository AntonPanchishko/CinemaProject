package com.dev.concert.service.impl;

import com.dev.concert.dao.ConcertSessionDao;
import com.dev.concert.model.ConcertSession;
import com.dev.concert.service.ConcertSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    @Autowired
    public ConcertSessionServiceImpl(ConcertSessionDao concertSessionDao) {
        this.concertSessionDao = concertSessionDao;
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public ConcertSession add(ConcertSession concertSession) {
        return concertSessionDao.add(concertSession);
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        return concertSessionDao.update(concertSession);
    }

    @Override
    public void delete(Long id) {
        concertSessionDao.delete(id);
    }

    @Override
    public ConcertSession get(Long id) {
        return concertSessionDao.getById(id).get();
    }
}

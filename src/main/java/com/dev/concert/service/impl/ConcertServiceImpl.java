package com.dev.concert.service.impl;

import com.dev.concert.dao.ConcertDao;
import com.dev.concert.model.Concert;
import com.dev.concert.service.ConcertService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    @Autowired
    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }

    @Override
    public Concert get(Long movieId) {
        return concertDao.getById(movieId).get();
    }
}

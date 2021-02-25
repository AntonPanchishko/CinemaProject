package com.dev.concert.service.impl;

import com.dev.concert.dao.ConcertHallDao;
import com.dev.concert.model.ConcertHall;
import com.dev.concert.service.ConcertHallService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcertHallServiceImpl implements ConcertHallService {
    private final ConcertHallDao concertHallDao;

    @Autowired
    public ConcertHallServiceImpl(ConcertHallDao concertHallDao) {
        this.concertHallDao = concertHallDao;
    }

    @Override
    public ConcertHall add(ConcertHall concertHall) {
        return concertHallDao.add(concertHall);
    }

    @Override
    public List<ConcertHall> getAll() {
        return concertHallDao.getAll();
    }

    @Override
    public ConcertHall get(Long concertHallId) {
        return concertHallDao.getById(concertHallId).get();
    }
}

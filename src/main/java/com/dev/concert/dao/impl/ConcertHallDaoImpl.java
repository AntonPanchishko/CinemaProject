package com.dev.concert.dao.impl;

import com.dev.concert.dao.ConcertHallDao;
import com.dev.concert.exceptions.DataBindingException;
import com.dev.concert.model.ConcertHall;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertHallDaoImpl implements ConcertHallDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ConcertHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ConcertHall add(ConcertHall concertHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concertHall);
            transaction.commit();
            return concertHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Cant insert entity in db" + concertHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<ConcertHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<ConcertHall> movieQuery = session.createQuery("FROM ConcertHall",
                    ConcertHall.class);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataBindingException("Can't get all Cinema Halls from db", e);
        }
    }

    @Override
    public Optional<ConcertHall> getById(Long cinemaHallId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(ConcertHall.class, cinemaHallId));
        } catch (Exception e) {
            throw new DataBindingException("Can't find entity by id " + cinemaHallId, e);
        }
    }
}

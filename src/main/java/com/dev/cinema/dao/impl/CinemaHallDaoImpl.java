package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.exceptions.DataBindingException;
import com.dev.cinema.model.CinemaHall;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CinemaHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(cinemaHall);
            transaction.commit();
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Cant insert entity in db" + cinemaHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<CinemaHall> movieQuery = session.createQuery("FROM CinemaHall", CinemaHall.class);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataBindingException("Can't get all Cinema Halls from db", e);
        }
    }

    @Override
    public Optional<CinemaHall> getById(Long cinemaHallId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(CinemaHall.class, cinemaHallId));
        } catch (Exception e) {
            throw new DataBindingException("Can't find entity by id " + cinemaHallId, e);
        }
    }
}

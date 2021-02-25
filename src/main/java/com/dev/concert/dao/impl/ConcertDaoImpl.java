package com.dev.concert.dao.impl;

import com.dev.concert.dao.ConcertDao;
import com.dev.concert.exceptions.DataBindingException;
import com.dev.concert.model.Concert;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertDaoImpl implements ConcertDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ConcertDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Concert add(Concert concert) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concert);
            transaction.commit();
            return concert;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Cant insert entity in db" + concert, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Concert> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Concert> getAllMoviesQuery = session.createQuery("FROM Concert", Concert.class);
            return getAllMoviesQuery.getResultList();
        } catch (Exception e) {
            throw new DataBindingException("Can't get all concerts from db", e);
        }
    }

    @Override
    public Optional<Concert> getById(Long movieId) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Concert.class, movieId));
        } catch (Exception e) {
            throw new DataBindingException("Can't find concert by id " + movieId, e);
        }
    }
}

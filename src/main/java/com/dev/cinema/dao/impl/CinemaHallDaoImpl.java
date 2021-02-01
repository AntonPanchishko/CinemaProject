package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.exceptions.DataBindingException;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {
    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CinemaHall> movieQuery = session.createQuery("FROM CinemaHall", CinemaHall.class);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataBindingException("Can't get all Cinema Halls from db", e);
        }
    }
}

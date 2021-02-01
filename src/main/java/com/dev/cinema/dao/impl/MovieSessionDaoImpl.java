package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.exceptions.DataBindingException;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> getAllSessionsDateQuery =
                    session.createQuery("SELECT m FROM MovieSession m "
                                    + " WHERE m.movie.id = :id_movie "
                                    + "AND DATE_FORMAT(m.sessionTime, '%Y-%m-%d') = :date ",
                            MovieSession.class);
            getAllSessionsDateQuery.setParameter("id_movie", movieId);
            getAllSessionsDateQuery.setParameter("date",
                    date.toString());
            return getAllSessionsDateQuery.getResultList();
        } catch (Exception e) {
            throw new DataBindingException("Can't get list with such date "
                    + date + " and id " + movieId, e);
        }
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't add movie session to DB" + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

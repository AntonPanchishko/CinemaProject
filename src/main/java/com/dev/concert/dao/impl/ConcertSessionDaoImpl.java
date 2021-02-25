package com.dev.concert.dao.impl;

import com.dev.concert.dao.ConcertSessionDao;
import com.dev.concert.exceptions.DataBindingException;
import com.dev.concert.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertSessionDaoImpl implements ConcertSessionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ConcertSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<ConcertSession> getAllSessionsDateQuery =
                    session.createQuery("SELECT m FROM ConcertSession m "
                                    + " WHERE m.movie.id = :id_movie "
                                    + "AND DATE_FORMAT(m.sessionTime, '%Y-%m-%d') = :date ",
                            ConcertSession.class);
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
    public ConcertSession add(ConcertSession concertSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concertSession);
            transaction.commit();
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't add movie session to DB" + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(concertSession);
            transaction.commit();
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't update movie session " + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ConcertSession concertSession = session.get(ConcertSession.class, id);
            session.delete(concertSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't delete movie session with id " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<ConcertSession> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(ConcertSession.class, id));
        } catch (Exception e) {
            throw new DataBindingException("Can't get movie session with id " + id, e);
        }
    }
}

package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.UserDao;
import com.dev.cinema.exceptions.DataBindingException;
import com.dev.cinema.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't add this user in BD "
                    + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT u FROM User u"
                    + " LEFT JOIN FETCH u.roles WHERE u.email = :email", User.class)
                      .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataBindingException("Can't find user with such email"
                    + email, e);
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT u FROM User u"
                    + " WHERE u.id = :id", User.class)
                    .setParameter("id", id).uniqueResultOptional();
        } catch (Exception e) {
            throw new DataBindingException("Can't find user by id " + id, e);
        }
    }
}

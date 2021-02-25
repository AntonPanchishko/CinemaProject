package com.dev.concert.dao.impl;

import com.dev.concert.dao.RoleDao;
import com.dev.concert.exceptions.DataBindingException;
import com.dev.concert.model.Role;
import com.dev.concert.model.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBindingException("Can't add new role " + role.getRoleName(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("SELECT Role FROM Role WHERE roleName = :roleName", Role.class)
                    .setParameter("roleName", Roles.valueOf(roleName))
                    .getSingleResult();
        } catch (Exception e) {
            throw new DataBindingException("Can't get Role:" + roleName, e);
        }
    }
}

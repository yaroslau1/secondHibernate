package com.work.dao;

import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infinispan.persistence.spi.PersistenceException;

import javax.transaction.Transactional;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class CountryDaoImpl implements CountryDao, Closeable {

    private Session session;
    private Transaction transaction;

    public CountryDaoImpl() throws DaoException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        }catch(Exception e){
        throw new DaoException("Some problems with constructor", e);
        }
    }

    public List<CountryEntity> getAll() throws DaoException {
        try {
            List<CountryEntity> countryEntities = (List<CountryEntity>) session.createQuery("From CountryEntity ").list();
            return countryEntities;
        } catch (Exception e) {
            throw new DaoException("Some problems with getAll", e);
        }
    }

    public void update(CountryEntity countryEntity) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.update(countryEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch(PersistenceException ex){
                    ex.addSuppressed(e);
                }
            }
            throw new DaoException("Some problems with update", e);
        }
    }

    public void delete(String name) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.delete(name);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch(PersistenceException ex){
                    ex.addSuppressed(e);
                }
            }
            throw new DaoException("Some problems with delete", e);
        }
    }

    public void insert(CountryEntity countryEntity) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.save(countryEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch(PersistenceException ex){
                    ex.addSuppressed(e);
                }
            }
            throw new DaoException("Some problems with insert", e);
        }
    }

    @Override
    public void close() throws IOException {
        session.close();
    }
}

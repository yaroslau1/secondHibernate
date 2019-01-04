package com.work.dao;

import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infinispan.persistence.spi.PersistenceException;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Savepoint;
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

    public CountryDaoImpl(String string) throws DaoException {
        try {
            session = HibernateUtil.getSessionFactoryTest().openSession();
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
            session.saveOrUpdate(countryEntity);
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

    public void delete(CountryEntity countryEntity) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.clear();
            session.delete(countryEntity);
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

    public void create(CountryEntity countryEntity) throws DaoException {
        transaction = session.beginTransaction();
        session.persist(countryEntity);
        transaction.commit();
        System.out.println("successfully saved");

    }

    @Override
    public void close() throws IOException {
        session.close();
    }
}

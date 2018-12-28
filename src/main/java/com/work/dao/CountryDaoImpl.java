package com.work.dao;

import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class CountryDaoImpl implements CountryDao, Closeable {

    private Session session;
    private Transaction transaction;

    public CountryDaoImpl() throws DaoException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
        }catch(Exception e){
        if(transaction != null){
            transaction.rollback();
        }
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
            session.update(countryEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Some problems with update", e);
        }
    }

    public void delete(String name) throws DaoException {
        try {
            session.delete(name);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Some problems with delete", e);
        }
    }

    public void insert(CountryEntity countryEntity) throws DaoException {
        try {
            session.save(countryEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Some problems with insert", e);
        }
    }

    @Override
    public void close() throws IOException {
        session.close();
    }
}

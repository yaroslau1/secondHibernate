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
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<CountryEntity> getAll() {
        List<CountryEntity> countryEntities = (List<CountryEntity>) session.createQuery("From CountryEntity ").list();
        return countryEntities;
    }

    public void update(CountryEntity countryEntity) {
            session.update(countryEntity);
            transaction.commit();
    }

    public void delete(String name) throws DaoException {
        session.delete(name);
        transaction.commit();
    }

    public void insert(CountryEntity countryEntity) throws DaoException {
        session.save(countryEntity);
        transaction.commit();
    }

    @Override
    public void close() throws IOException {
        session.close();
    }
}

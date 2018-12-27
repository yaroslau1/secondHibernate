package com.work.dao;

import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CountryDaoImpl implements CountryDao {

    public List<CountryEntity> getAll() throws DaoException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (List<CountryEntity>) HibernateUtil.getSessionFactory().openSession()
                .createQuery("From CountryEntity ").list();
    }

    public void update(CountryEntity countryEntity) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(countryEntity);
        transaction.commit();
        session.close();
    }

    public void delete(String name) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(name);
        transaction.commit();
        session.close();
    }

    public void insert(CountryEntity countryEntity) throws DaoException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(countryEntity);
        transaction.commit();
        session.close();
    }
}

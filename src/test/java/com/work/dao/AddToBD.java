package com.work.dao;

import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddToBD {

    private Session session;
    private Transaction transaction;

    public void create() throws DaoException {
        session = HibernateUtil.getSessionFactoryTest().openSession();
        transaction = session.beginTransaction();
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName("Belarus");
        countryEntity.setCode("BLR");
        countryEntity.setPopulation(100);
        session.persist(countryEntity);
        transaction.commit();
        session.close();
        System.out.println("successfully saved");
    }
}

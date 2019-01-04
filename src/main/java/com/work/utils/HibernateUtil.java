package com.work.utils;

import com.work.dao.CityEntity;
import com.work.dao.CountryEntity;
import com.work.dao.CountrylanguageEntity;
import com.work.exception.DaoException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory() throws DaoException {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(CityEntity.class);
                configuration.addAnnotatedClass(CountryEntity.class);
                configuration.addAnnotatedClass(CountrylanguageEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
                //throw new DaoException(e);
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactoryTest() throws DaoException {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(CountryEntity.class);
                configuration.addAnnotatedClass(CityEntity.class);

                configuration.addAnnotatedClass(CountrylanguageEntity.class);
                configuration.configure("hibernate-test.cfg.xml");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
                //throw new DaoException(e);
            }
        }
        return sessionFactory;
    }
}

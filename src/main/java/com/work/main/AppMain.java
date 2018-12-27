package com.work.main;

import com.work.dao.CountryDaoImpl;
import com.work.dao.CountryEntity;
import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        CountryDaoImpl countryDao = new CountryDaoImpl();
        CountryEntity countryEntity = new CountryEntity("UKR", "Ukraine", 16000000, 150000000);
        try {
           // countryDao.insert(countryEntity);
            System.out.println(countryDao.getAll());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}

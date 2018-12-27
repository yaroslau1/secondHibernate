package com.work.main;

import com.work.dao.CountryDaoImpl;
import com.work.dao.CountryEntity;
import com.work.exception.DaoException;
import com.work.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        try (CountryDaoImpl countryDao = new CountryDaoImpl()){
            System.out.println(countryDao.getAll());
        } catch (DaoException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

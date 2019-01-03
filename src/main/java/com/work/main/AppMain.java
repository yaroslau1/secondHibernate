package com.work.main;

import com.work.dao.CountryDaoImpl;
import com.work.dao.CountryEntity;
import com.work.exception.DaoException;

import java.io.IOException;

public class AppMain {

    public static void main(String[] args) {
        CountryEntity countryEntity = new CountryEntity("UKR", "Ukraine", 16000000, 2);
        try (CountryDaoImpl countryDao = new CountryDaoImpl()){
            countryDao.delete(countryEntity);
            System.out.println(countryDao.getAll());
        } catch (DaoException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

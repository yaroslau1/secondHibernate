package com.work.dao;

import com.work.exception.DaoException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CountryDaoImplTest {
    private static CountryDaoImpl countryDao;

    @BeforeClass
    public static void open(){
        try {
            countryDao = new CountryDaoImpl();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void close(){
        try {
            countryDao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() {
        List<CountryEntity> countryEntities;
        try {
            countryEntities = countryDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void insert() {
    }
}
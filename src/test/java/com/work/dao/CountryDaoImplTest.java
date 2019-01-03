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
            countryDao = new CountryDaoImpl("test");
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
            System.out.println(countryEntities);
            assertEquals("BLR",countryEntities.get(0).getCode());
            assertEquals("Belarus",countryEntities.get(0).getName());
            assertEquals(250,countryEntities.get(0).getPopulation());
            assertEquals("GRD",countryEntities.get(1).getCode());
            assertEquals("",countryEntities.get(1).getName());
            assertEquals(0,countryEntities.get(1).getPopulation());
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update() {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("GDR","Germany",123,15);
        try {
            countryDao.update(countryEntity);
            countryEntities = countryDao.getAll();
            System.out.println(countryEntities);
            assertEquals("GRD",countryEntities.get(1).getCode());
            assertEquals("Germany",countryEntities.get(1).getName());
            assertEquals(0,countryEntities.get(1).getPopulation());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        List<CountryEntity> countryEntities;
        String name = "Germany";
        try {
            countryDao.delete(name);
            countryEntities = countryDao.getAll();
            System.out.println(countryEntities);
            assertEquals(1,countryEntities.size());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("UK","Great Britain",256,18);
        try {
            countryDao.insert(countryEntity);
            countryEntities = countryDao.getAll();
            System.out.println(countryEntities);
            assertEquals("UK",countryEntities.get(2).getCode());
            assertEquals("Great Britain",countryEntities.get(2).getName());
            assertEquals(256,countryEntities.get(2).getPopulation());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
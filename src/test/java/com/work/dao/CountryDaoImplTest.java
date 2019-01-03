package com.work.dao;

import com.work.exception.DaoException;
import org.junit.*;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CountryDaoImplTest {
    private CountryDaoImpl countryDao;

    @Before
    public void open() {
        try {
            countryDao = new CountryDaoImpl("test");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() throws DaoException {
        List<CountryEntity> countryEntities;

        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("BLR", countryEntities.get(0).getCode());
        assertEquals("Belarus", countryEntities.get(0).getName());
        assertEquals(256, countryEntities.get(0).getPopulation());
        assertEquals("GDR", countryEntities.get(1).getCode());
        assertEquals("Germany", countryEntities.get(1).getName());
        assertEquals(123, countryEntities.get(1).getPopulation());

    }

    @After
    public void close() {
        try {
            countryDao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void openUpdate() {
        try {
            countryDao = new CountryDaoImpl("test");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("GDR", "Germany", 123, 15);
        countryDao.update(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("GDR", countryEntities.get(1).getCode());
        assertEquals("Germany", countryEntities.get(1).getName());
        assertEquals(123, countryEntities.get(1).getPopulation());
    }

    @After
    public void closeUpdate() {
        try {
            countryDao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void openDelete() {
        try {
            countryDao = new CountryDaoImpl("test");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("UK", "Great Britain", 256, 18);
        countryDao.delete(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals(2, countryEntities.size());
    }

    @After
    public void closeDelete() {
        try {
            countryDao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void openInsert() {
        try {
            countryDao = new CountryDaoImpl("test");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("UK", "Great Britain", 256, 18);
        countryDao.insert(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("UK", countryEntities.get(2).getCode());
        assertEquals("Great Britain", countryEntities.get(2).getName());
        assertEquals(256, countryEntities.get(2).getPopulation());
    }

    @After
    public void closeInsert() {
        try {
            countryDao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
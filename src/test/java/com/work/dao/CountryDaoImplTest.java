package com.work.dao;

import com.work.exception.DaoException;
import org.junit.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CountryDaoImplTest {
    private CountryDaoImpl countryDao;

    @Before
    public void open() throws DaoException {
        countryDao = new CountryDaoImpl("test");
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
    public void close() throws DaoException, IOException {
            countryDao.close();
    }

    @Before
    public void openUpdate() throws DaoException {
            countryDao = new CountryDaoImpl("test");
    }

    @Test
    public void update() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("GDR", "Germany", 123, 15);
        countryDao.update(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("GDR", countryEntities.get(0).getCode());
        assertEquals("Germany", countryEntities.get(0).getName());
        assertEquals(123, countryEntities.get(0).getPopulation());
    }

    @After
    public void closeUpdate() throws IOException {
            countryDao.close();
    }

    @Before
    public void openDelete() throws DaoException {
            countryDao = new CountryDaoImpl("test");
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
    public void closeDelete() throws IOException {
            countryDao.close();
    }

    @Before
    public void openInsert() throws DaoException {
            countryDao = new CountryDaoImpl("test");
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
    public void closeInsert() throws IOException {
            countryDao.close();
    }
}
package com.work.dao;

import com.work.exception.DaoException;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class CountryDaoImplTestNG {

    private CountryDaoImpl countryDao;
    private CountryEntity countryEntity = new CountryEntity("BLR", "Belarus", 100, 10);

    @BeforeClass
    public void open() throws DaoException {
        countryDao = new CountryDaoImpl("test");
        countryDao.create(countryEntity);
    }

    @AfterClass
    public void close() throws DaoException, IOException {
        countryDao.close();
    }

    @Test(priority=1)
    public void getAll() throws DaoException {
        List<CountryEntity> countryEntities;
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("BLR", countryEntities.get(0).getCode());
        assertEquals("Belarus", countryEntities.get(0).getName());
        assertEquals(100, countryEntities.get(0).getPopulation());
    }

    @Test(priority=2)
    public void update() throws DaoException {
        List<CountryEntity> countryEntities;
        countryEntity.setPopulation(123);
        countryDao.update(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("BLR", countryEntities.get(0).getCode());
        assertEquals("Belarus", countryEntities.get(0).getName());
        assertEquals(123, countryEntities.get(0).getPopulation());
    }

    @Test(priority=3)
    public void delete() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("BLR", "Belarus", 123, 18);
        countryDao.delete(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals(0, countryEntities.size());
    }

    @Test(priority = 4)
    public void insert() throws DaoException {
        List<CountryEntity> countryEntities;
        CountryEntity countryEntity = new CountryEntity("UK", "Great Britain", 100, 18);
        countryDao.insert(countryEntity);
        countryEntities = countryDao.getAll();
        System.out.println(countryEntities);
        assertEquals("UK", countryEntities.get(0).getCode());
        assertEquals("Great Britain", countryEntities.get(0).getName());
        assertEquals(100, countryEntities.get(0).getPopulation());
    }
}
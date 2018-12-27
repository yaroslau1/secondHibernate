package com.work.dao;

import com.work.exception.DaoException;

import java.util.List;

public interface CountryDao {
    List<CountryEntity> getAll() throws DaoException;
    void update(CountryEntity countryEntity) throws DaoException;
    void delete(String name) throws DaoException;
    void insert(CountryEntity countryEntity) throws DaoException;
}

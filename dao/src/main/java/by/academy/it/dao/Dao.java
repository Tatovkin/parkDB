package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;

import java.io.Serializable;

interface Dao<T> {

    T saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}


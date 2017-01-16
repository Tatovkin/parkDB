package by.academy.it;

import java.io.Serializable;

interface IService<T> {

    T saveOrUpdate(T t);

    T get(Serializable id);

    T load(Serializable id);

    boolean delete(T t);

}

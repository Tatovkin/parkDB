package by.academy.it;

import by.academy.it.util.HibernateUtil;

import java.io.Serializable;

/**
 * Interface for entities service
 *
 * @param <T> type of entity
 */
interface IEntityService<T> {

    HibernateUtil util = HibernateUtil.getHibernateUtil();

    /**
     * Save or update new entity in DB
     *
     * @param t Entity type
     * @return entity object
     */
    T saveOrUpdate(T t);

    /**
     * Get entity object
     *
     * @param id ID of entity
     * @return entity object
     */
    T get(Serializable id);

    /**
     * Load entity object from DB
     *
     * @param id ID of entity
     * @return entity object
     */
    T load(Serializable id);

    /**
     * Delete entity from DB
     *
     * @param t entity for deleting
     * @return true if entity removed successfully or false otherwise
     */
    boolean delete(T t);

}

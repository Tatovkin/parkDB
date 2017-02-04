package by.academy.it;

import by.academy.it.dao.PlantDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Plant;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PlantSevice implements IEntityService<Plant> {

    private static PlantDao dao = PlantDao.getDao();
    private static Logger log = Logger.getLogger(PlantSevice.class);
    private Transaction transaction = null;

    @Override
    public Plant saveOrUpdate(Plant plant) {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            dao.saveOrUpdate(plant);

            log.info("Save or update (commit):" + plant);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return plant;
    }

    @Override
    public Plant get(Serializable id) {
        Plant plant = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            plant = dao.get(id);

            log.info("Get (commit):" + plant);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return plant;
    }

    @Override
    public Plant load(Serializable id) {
        Plant plant = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            plant = dao.load(id);

            log.info("Load (commit):" + plant);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return plant;
    }

    @Override
    public boolean delete(Plant plant) {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            dao.delete(plant);

            log.info("Delete (commit):" + plant);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}

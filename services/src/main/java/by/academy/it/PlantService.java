package by.academy.it;

import by.academy.it.dao.PlantDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Plant;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class PlantService implements IEntityService<Plant> {

    private static PlantDao dao = PlantDao.getDao();
    private static Logger log = Logger.getLogger(PlantService.class);

    @Override
    public Plant saveOrUpdate(Plant plant) {
        try {
            util.beginTransaction();

            dao.saveOrUpdate(plant);
            log.info("Save or update (commit):" + plant);

            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return null;
        }
        return plant;
    }

    @Override
    public Plant get(Serializable id) {
        Plant plant = null;
        try {
            util.beginTransaction();

            plant = dao.get(id);

            log.info("Get (commit):" + plant);
            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return null;
        }
        return plant;
    }

    @Override
    public Plant load(Serializable id) {
        Plant plant = null;
        try {
            util.beginTransaction();

            plant = dao.load(id);
            log.info("Load (commit):" + plant);

            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return null;
        }
        return plant;
    }

    @Override
    public boolean delete(Plant plant) {
        try {
            util.beginTransaction();

            dao.delete(plant);
            log.info("Delete (commit):" + plant);

            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return false;
        }
        return true;
    }
}

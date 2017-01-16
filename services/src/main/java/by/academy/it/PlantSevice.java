package by.academy.it;

import by.academy.it.dao.PlantDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Plant;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class PlantSevice implements IService<Plant> {

    private PlantDao dao = PlantDao.getDao();
    private Logger log = Logger.getLogger(PlantSevice.class);

    @Override
    public Plant saveOrUpdate(Plant plant) {
        try {
            dao.saveOrUpdate(plant);
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
            plant = dao.get(id);
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
            plant = dao.load(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return plant;
    }

    @Override
    public boolean delete(Plant plant) {
        try {
            dao.delete(plant);
            return true;
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}

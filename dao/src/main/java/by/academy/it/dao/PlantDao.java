package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Plant;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader.PersonLoader.util;

public class PlantDao extends BaseDao<Plant> {

    private static Logger log = Logger.getLogger(PersonDao.class);

    public void flush(Integer id, String type) throws DaoException {
        try {
            Session session = util.getSession();

            Plant plant = (Plant)session.get(Plant.class, id);
            System.out.println(plant);

            plant.setType(type);
            System.out.println(plant);

            session.flush();
            System.out.println(plant);
        } catch (HibernateException e) {
            log.error("Error Flush " + Plant.class.getName() + e);
            throw new DaoException(e);
        }

    }
}

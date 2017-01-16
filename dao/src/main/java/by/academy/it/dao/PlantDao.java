package by.academy.it.dao;

import by.academy.it.entities.Plant;

public class PlantDao extends BaseDao<Plant> {

    private static PlantDao dao = null;

    public static synchronized PlantDao getDao() {
        if (dao == null) {
            dao = new PlantDao();
        }
        return dao;
    }

}

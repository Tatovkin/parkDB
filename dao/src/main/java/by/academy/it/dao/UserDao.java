package by.academy.it.dao;

import by.academy.it.entities.User;

public class UserDao extends BaseDao<User> {

    private static UserDao dao = null;

    public static synchronized UserDao getDao() {
        if (dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

}

package by.academy.it;

import by.academy.it.dao.UserDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.User;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class UserService implements IService<User> {

    private static UserDao dao = UserDao.getDao();
    private Logger log = Logger.getLogger(UserService.class);

    @Override
    public User saveOrUpdate(User user) {
        try {
            dao.saveOrUpdate(user);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return user;
    }

    @Override
    public User get(Serializable id) {
        User user = null;
        try {
            user = dao.get(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return user;
    }

    @Override
    public User load(Serializable id) {
        User user = null;
        try {
            user = dao.load(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return user;
    }

    @Override
    public boolean delete(User user) {
        try {
            dao.delete(user);
            return true;
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}

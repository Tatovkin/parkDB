package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader.PersonLoader.util;

public class UserDao extends BaseDao<User> {

    private static Logger log = Logger.getLogger(PersonDao.class);
    private static UserDao dao = null;

    public static synchronized UserDao getDao() {
        if (dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

    public void flush(Integer id, String newLogin) throws DaoException {
        try {
            Session session = util.getSession();

            User user = (User)session.get(User.class, id);
            System.out.println(user);

            user.setLogin(newLogin);
            System.out.println(user);

            session.flush();
            System.out.println(user);
        } catch (HibernateException e) {
            log.error("Error Flush user" + e);
            throw new DaoException(e);
        }
    }
}

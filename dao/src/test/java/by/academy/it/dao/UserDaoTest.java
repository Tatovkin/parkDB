package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.UserRole;
import by.academy.it.entities.User;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Unit tests for userDao
 */
@FixMethodOrder(value = MethodSorters.JVM)
public class UserDaoTest extends TestCase {

    private static UserDao userDao = null;
    private static Logger log = Logger.getLogger(UserDaoTest.class);
    private static User user;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserDaoTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static junit.framework.Test suite() {
        return new TestSuite(UserDaoTest.class);
    }


    public void testCreateUser() {
        user = getUser();
        try {
            getUserDao().saveOrUpdate(user);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertNotNull(user.getId());
    }

    public void testUpdateUser() {
        user = getUser();

        // update
        user.setLogin("testLoginNew");
        user.setPassword("testPasswordNew");
        user.setEmail("testEmailNew@gmail.com");
        user.setRole(UserRole.FORESTER.name());

        User updatedUser = user;
        try {
            getUserDao().saveOrUpdate(user);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertEquals(updatedUser, user);
    }

    public void testViewUser() {
        User currentUser = user;

        try {
            getUserDao().get(user.getId());
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertEquals(currentUser, user);
    }

    public void testDeleteUser() {
        Assert.assertNotNull(user);

        User deletedUser = null;
        try {
            getUserDao().delete(user);
            deletedUser = getUserDao().get(user.getId());
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertNull(deletedUser);
    }

    private User getUser() {
        if (user == null) {
            user = new User();
            user.setLogin("testLogin");
            user.setPassword("testPassword");
            user.setEmail("testEmail@gmail.com");
            user.setRole(UserRole.DIRECTOR.name());
        }
        return user;
    }

}

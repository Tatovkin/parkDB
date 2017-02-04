package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Account;
import by.academy.it.entities.Person;
import by.academy.it.entities.Role;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Unit tests for dao
 */
@FixMethodOrder(value = MethodSorters.JVM)
public class AccountDaoTest extends TestCase {

    private static AccountDao dao = new AccountDao();
    private static Logger log = Logger.getLogger(AccountDaoTest.class);
    private static Account account;
    private static Person person;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AccountDaoTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static junit.framework.Test suite() {
        return new TestSuite(AccountDaoTest.class);
    }


    public void testCreateUser() {
        account = getAccount();
        try {
            dao.saveOrUpdate(account);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertNotNull(account.getId());
    }

    public void testUpdateUser() {
        account = getAccount();

        // update
        account.setLogin("testLoginNew");
        account.setPassword("testPasswordNew");
        account.setEmail("testEmailNew@gmail.com");
        account.setRole(Role.FORESTER.name());

        Account updatedAccount = account;
        try {
            dao.saveOrUpdate(account);
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertEquals(updatedAccount, account);
    }

    public void testViewUser() {
        Account currentAccount = account;

        try {
            dao.get(account.getId());
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertEquals(currentAccount, account);
    }

    public void testDeleteUser() {
        Assert.assertNotNull(account);

        Account deletedAccount = null;
        try {
            dao.delete(account);
            deletedAccount = dao.get(account.getId());
        } catch (DaoException e) {
            log.error(e);
            throw new Error(e.getMessage());
        }

        Assert.assertNull(deletedAccount);
    }

    private Account getAccount() {
        if (account == null) {
            account = new Account();
            account.setLogin("testLogin");
            account.setPassword("testPassword");
            account.setEmail("testEmail@gmail.com");
            account.setRole(Role.DIRECTOR.name());
            account.setPerson(getPerson());
        }
        return account;
    }

    private Person getPerson() {
        if (person == null) {
            person = new Person();
            person.setFirstName("Vasya");
            person.setLastName("Pupkin");
        }
        return person;
    }

}

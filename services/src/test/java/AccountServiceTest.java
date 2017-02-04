import by.academy.it.AccountService;
import by.academy.it.entities.Account;
import by.academy.it.entities.Person;
import by.academy.it.entities.Role;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Date;

@FixMethodOrder(value = MethodSorters.JVM)
public class AccountServiceTest extends TestCase {

    private static AccountService service = new AccountService();
    private static Logger log = Logger.getLogger(AccountServiceTest.class);
    private static Account account;
    private static Person person;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AccountServiceTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static junit.framework.Test suite() {
        return new TestSuite(AccountServiceTest.class);
    }


    public void testCreateUser() {
        account = getAccount();

        account = service.saveOrUpdate(account);

        Assert.assertNotNull(account);
    }

    public void testReadUser() {
        Account actual = service.get(account.getId());

        Assert.assertEquals(account, actual);
    }

    public void testUpdateUser() {
        account.setDate(new Date());
        account.setLogin("testNewLogin");
        account.setPassword("testNewPassword");
        account.setEmail("testNewEmail@gmail.com");
        account.setRole(Role.FORESTER.name());

        Account updated = service.saveOrUpdate(account);

        Assert.assertEquals(account, updated);
    }

    public void testDeleteUser() {
        boolean deleted = service.delete(account);

        Assert.assertTrue(deleted);
        account = null;
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

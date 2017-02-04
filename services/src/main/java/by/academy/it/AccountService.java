package by.academy.it;

import by.academy.it.dao.AccountDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class AccountService implements IEntityService<Account> {

    private static AccountDao dao = AccountDao.getDao();
    private static Logger log = Logger.getLogger(AccountService.class);
    private Transaction transaction = null;

    @Override
    public Account saveOrUpdate(Account account) {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            dao.saveOrUpdate(account);

            log.info("Save or update (commit):" + account);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            transaction.rollback();

            return null;
        }
        return account;
    }

    @Override
    public Account get(Serializable id) {
        Account account;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            account = dao.get(id);

            log.info("Get (commit):" + account);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            transaction.rollback();
            return null;
        }
        return account;
    }

    @Override
    public Account load(Serializable id) {
        Account account = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            account = dao.load(id);

            log.info("Load (commit):" + account);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            transaction.rollback();
            return null;
        }
        return account;
    }

    @Override
    public boolean delete(Account account) {
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();

            dao.delete(account);

            log.info("Delete (commit):" + account);
            transaction.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}

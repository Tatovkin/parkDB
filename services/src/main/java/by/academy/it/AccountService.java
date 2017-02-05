package by.academy.it;

import by.academy.it.dao.AccountDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.Account;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class AccountService implements IEntityService<Account> {

    private static AccountDao dao = AccountDao.getDao();
    private static Logger log = Logger.getLogger(AccountService.class);

    @Override
    public Account saveOrUpdate(Account account) {
        try {
            util.beginTransaction();

            dao.saveOrUpdate(account);

            log.info("Save or update (commit):" + account);
            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();

            return null;
        }
        return account;
    }

    @Override
    public Account get(Serializable id) {
        Account account;
        try {
            util.beginTransaction();

            account = dao.get(id);

            log.info("Get (commit):" + account);
            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return null;
        }
        return account;
    }

    @Override
    public Account load(Serializable id) {
        Account account = null;
        try {
            util.beginTransaction();

            account = dao.load(id);

            log.info("Load (commit):" + account);
            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return null;
        }
        return account;
    }

    @Override
    public boolean delete(Account account) {
        try {
            util.beginTransaction();

            dao.delete(account);

            log.info("Delete (commit):" + account);
            util.commit();
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            util.rollback();
            return false;
        }
        return true;
    }
}

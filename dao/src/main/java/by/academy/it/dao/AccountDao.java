package by.academy.it.dao;

import by.academy.it.entities.Account;

public class AccountDao extends BaseDao<Account> {

    private static AccountDao dao = null;

    public static synchronized AccountDao getDao() {
        if (dao == null) {
            dao = new AccountDao();
        }
        return dao;
    }

}

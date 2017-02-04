package by.academy.it.command;

import by.academy.it.AccountService;
import by.academy.it.entities.Account;
import by.academy.it.entities.Role;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class CmdSignup extends Action {

    private static Logger log = Logger.getLogger(CmdSignup.class);
    private static AccountService service = new AccountService();

    @Override
    Action execute(HttpServletRequest request) {
        Account account = new Account();
        try {
            account.setLogin(Form.getString(request, "login", Patterns.LOGIN));
            account.setPassword(Form.getString(request, "password", Patterns.PASSWORD));
            account.setEmail(Form.getString(request, "email", Patterns.EMAIL));
            account.setRole(Role.FORESTER.name());
        } catch (Exception e) {
            request.setAttribute(Messages.msgError, "NO VALID FIELDS");
            log.error(e);
            return null;
        }

        if (account.getLogin() != null & account.getPassword() != null & account.getEmail() != null) {
            Account createdAccount = service.saveOrUpdate(account);
            if (createdAccount == null) {
                request.setAttribute(Messages.msgError, "FILL ERROR");
                return null;
            }
            request.setAttribute(Messages.msgMessage, "USER ADDED");
            return Actions.LOGIN.action;
        } else {
            request.setAttribute(Messages.msgError, "FILL ERROR");
        }

        return null;
    }
}

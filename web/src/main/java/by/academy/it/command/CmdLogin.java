package by.academy.it.command;


import by.academy.it.AccountService;
import by.academy.it.entities.Account;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CmdLogin extends Action {

    private static Logger log = Logger.getLogger(CmdLogin.class);
    private static AccountService service = new AccountService();

    @Override
    Action execute(HttpServletRequest request) {

        Account account = null;
        if (Form.isPost(request)) {
            try {
                account = new Account();
                account.setLogin(Form.getString(request, "Login", Patterns.LOGIN));
                account.setPassword(Form.getString(request, "Password", Patterns.PASSWORD));
            } catch (Exception e) {
                request.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }

            account = service.get(account);

            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                session.setAttribute("userRole", account.getRole());
                session.setMaxInactiveInterval(60 * 5);
                return Actions.PROFILE.action;
            }
            request.setAttribute(Messages.msgError, "NO SUCH USER");
        }
        return null;
    }
}


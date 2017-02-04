package by.academy.it.command;

import by.academy.it.entities.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account != null) request.setAttribute(Messages.msgMessage, "login");
        request.getSession();

        if (Form.isPost(request) && Integer.valueOf(request.getParameter("LogoutButton")) == 1) {
            request.getSession().invalidate();
        }

        return Actions.LOGIN.action;
    }
}

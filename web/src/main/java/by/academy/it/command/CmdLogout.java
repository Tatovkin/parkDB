package by.academy.it.command;

import by.academy.it.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdLogout extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) request.setAttribute(Messages.msgMessage, "login");
        request.getSession();

        if (Form.isPost(request) && Integer.valueOf(request.getParameter("LogoutButton")) == 1) {
            request.getSession().invalidate();
        }

        return Actions.LOGIN.action;
    }
}

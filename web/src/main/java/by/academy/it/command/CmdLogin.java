package by.academy.it.command;


import by.academy.it.dao.UserDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CmdLogin extends Action {

    private static Logger log = Logger.getLogger(CmdLogin.class);

    @Override
    Action execute(HttpServletRequest request) {

        User user = null;
        if (Form.isPost(request)) {
            try {
                user = new User();
                user.setLogin(Form.getString(request, "Login", Patterns.LOGIN));
                user.setPassword(Form.getString(request, "Password", Patterns.PASSWORD));
            } catch (Exception e) {
                request.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }

            UserDao dao = UserDao.getDao();
            try {
                user = dao.get(user);
            } catch (DaoException e) {
                log.error(e);
            }

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userRole", user.getRole());
                session.setMaxInactiveInterval(60 * 5);
                return Actions.PROFILE.action;
            }
            request.setAttribute(Messages.msgError, "NO SUCH USER");
        }
        return null;
    }
}


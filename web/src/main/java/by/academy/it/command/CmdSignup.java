package by.academy.it.command;

import by.academy.it.Services;
import by.academy.it.UserService;
import by.academy.it.entities.User;
import by.academy.it.entities.UserRole;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class CmdSignup extends Action {

    private static Logger log = Logger.getLogger(CmdSignup.class);
    private static UserService service = Services.getUserService();

    @Override
    Action execute(HttpServletRequest request) {
        User user = new User();
        try {
            user.setLogin(Form.getString(request, "login", Patterns.LOGIN));
            user.setPassword(Form.getString(request, "password", Patterns.PASSWORD));
            user.setEmail(Form.getString(request, "email", Patterns.EMAIL));
            user.setRole(UserRole.FORESTER.name());
        } catch (Exception e) {
            request.setAttribute(Messages.msgError, "NO VALID FIELDS");
            log.error(e);
            return null;
        }

        if (user.getLogin() != null & user.getPassword() != null & user.getEmail() != null) {
            User createdUser = service.saveOrUpdate(user);
            if (createdUser == null) {
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

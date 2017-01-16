package by.academy.it.command;


import by.academy.it.entities.User;

import javax.servlet.http.HttpServletRequest;

public class CmdProfile extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            User user = (User) request.getSession().getAttribute("user");
            return null;
        } else return Actions.LOGIN.action;
    }
}
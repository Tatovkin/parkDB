package by.academy.it.command;


import by.academy.it.entities.Account;

import javax.servlet.http.HttpServletRequest;

public class CmdProfile extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            Account account = (Account) request.getSession().getAttribute("account");
            return null;
        } else return Actions.LOGIN.action;
    }
}
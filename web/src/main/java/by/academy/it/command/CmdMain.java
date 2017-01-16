package by.academy.it.command;


import javax.servlet.http.HttpServletRequest;

public class CmdMain extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        //DAO dao = DAO.getDAO();
        //TODO

        return Actions.MAIN.action;
    }
}

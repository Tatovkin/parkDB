package by.academy.it.command;

import javax.servlet.http.HttpServletRequest;

abstract public class Action {

    private Action redirectAction;

    abstract Action execute(HttpServletRequest request);

    public Action getRedirectAction() {
        return redirectAction;
    }

    public void setRedirectAction(Action redirectAction) {
        this.redirectAction = redirectAction;
    }

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName();
        name = name.replace("Cmd", "");
        return name;
    }

    public String getJsp() {
        String name = this.toString().toLowerCase();
        return "/" + name + ".jsp";
    }

}

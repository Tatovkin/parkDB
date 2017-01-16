package by.academy.it.command;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    MAIN {{
        this.action = new CmdMain();
    }},
    PROFILE {{
        this.action = new CmdProfile();
    }},
    SIGNUP {{
        this.action = new CmdSignup();
    }},
    LOGIN {{
        this.action = new CmdLogin();
    }},
    LOGOUT {{
        this.action = new CmdLogout();
    }},
    ERROR {{
        this.action = new CmdError();
    }};

    protected Action action = null;

    static Action defineFrom(HttpServletRequest request) {
        Action result;

        String cmdName = request.getParameter("command").toUpperCase();

        try {
            result = Actions.valueOf(cmdName).action;
        } catch (IllegalArgumentException e) {
            result = Actions.ERROR.action;
        }
        return result;
    }
}

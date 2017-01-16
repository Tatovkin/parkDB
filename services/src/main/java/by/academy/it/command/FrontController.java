package by.academy.it.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/do", name = "FrontController")
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Action action = Actions.defineFrom(request);
        Action nexAction = action.execute(request);

        if (nexAction == null) {
            RequestDispatcher r = getServletContext().getRequestDispatcher(action.getJsp());
            r.forward(request, response);
        } else
            response.sendRedirect("/web/do?command=" + nexAction);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Action action = Actions.defineFrom(request);
        action.execute(request);
        RequestDispatcher r = getServletContext().getRequestDispatcher(action.getJsp());
        r.forward(request, response);
    }
}

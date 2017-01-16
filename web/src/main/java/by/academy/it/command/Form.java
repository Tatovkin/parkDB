package by.academy.it.command;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class Form {
    static String getString(HttpServletRequest request,
                            String parameter,
                            String pattern) throws ParseException {
        String value = request.getParameter(parameter);
        if (value != null) {
            if (value.matches(pattern))
                return value;
            else
                throw new ParseException("Incorrect String: " + parameter, 0);
        }
        return null;
    }

    static int getInt(HttpServletRequest request,
                      String parameter) throws ParseException {
        String value = request.getParameter(parameter);
        if (value != null) {
            if (value.matches("[0-9-]+")) {
                return (Integer.parseInt(value));
            }
        }
        throw new ParseException("Incorrect String: " + parameter, 0);
    }

    static boolean isPost(HttpServletRequest request) {
        return (request.getMethod() != null && request.getMethod().equalsIgnoreCase("post"));
    }
}

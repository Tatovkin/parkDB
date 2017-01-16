package by.academy.it.loader;

import by.academy.it.entities.User;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Locale;

import static by.academy.it.loader.MenuLoader.menu;

public class UserLoader {

    public static HibernateUtil util = null;
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        util = HibernateUtil.getHibernateUtil();

        User user = new User(null, "myLogin", "myPass", "myEmail@gmail.com", "ADMIN");
        Session session = util.getSession();

        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();

        System.out.println("Start Menu");
        menu();
    }
}

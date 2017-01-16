package by.academy.it.loader;
import by.academy.it.entities.Person;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Locale;

import static by.academy.it.loader.MenuLoader.menu;

public class PersonLoader {
    public static HibernateUtil util = null;
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        util = HibernateUtil.getHibernateUtil();
        Person person = new Person(null, 35, "Yuli", "Slabko");
        Session session = util.getSession();
        session.saveOrUpdate(person);
        System.out.println("Start Menu");
        menu();
    }
}



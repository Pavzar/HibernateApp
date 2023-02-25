package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Item;
import pav.zar.hibernateapp.model.Passport;
import pav.zar.hibernateapp.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test person", 33);
            Passport passport = new Passport(3213213);

            person.setPassport(passport);

            session.save(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}

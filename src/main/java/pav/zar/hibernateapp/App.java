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

//            Person person = new Person("Test person", 33);
//            Passport passport = new Passport(3213213);
//
//            person.setPassport(passport);
//
//            session.save(person);

//            Person person = session.get(Person.class, 7);
//            System.out.println(person.getPassport().getPassportNumber());
//            person.getPassport().setPassportNumber(5555554);
//            System.out.println(person.getPassport().getPassportNumber());

            Person person = session.get(Person.class, 7);

            session.remove(person);
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }

//        configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
//        sessionFactory = configuration.buildSessionFactory();
//        session = sessionFactory.getCurrentSession();
//
//        try {
//            session.beginTransaction();
//
//            Passport passport = session.get(Passport.class,6);
//            System.out.println(passport.getPerson().getName());
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }


    }
}

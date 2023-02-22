package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Item;
import pav.zar.hibernateapp.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 4);

            Item item = session.get(Item.class, 1);

            //correct cache
            item.getOwner().getItems().remove(item);

            //sql
            item.setOwner(person);

            //correct cache
            person.getItems().add(item);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

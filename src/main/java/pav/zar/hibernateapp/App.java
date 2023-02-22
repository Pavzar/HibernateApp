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

//            Person person = session.get(Person.class, 2);
//            Item newItem = new Item("Item from Hibernate", person);
//
//            person.getItems().add(newItem);
//
//            session.save(newItem);

            Person person = new Person("Test person", 30);
            Item newItem = new Item("Item from Hibernate 2", person);

            person.setItems(new ArrayList<Item>(Collections.singleton(newItem)));

            session.save(person);
            session.save(newItem);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

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

            Person person = session.get(Person.class, 3);

            List<Item> items = person.getItems();

            //sql
            for(Item item: items){
                session.remove(item);
            }

            //it is necessary to be sure everything is correct in Hibernate's cache
            person.getItems().clear();

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

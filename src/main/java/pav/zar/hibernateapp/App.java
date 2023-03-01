package pav.zar.hibernateapp;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.*;

import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Got person");

            session.getTransaction().commit();
            System.out.println("closed session");

            //open a new session and transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            person = (Person) session.merge(person);

//            Hibernate.initialize(person.getItems());
            //HQL code
            List<Item> items = session.createQuery("select i from Item i where i.owner.id =:personId", Item.class)
                    .setParameter("personId", person.getId()).getResultList();

            System.out.println(items);
            session.getTransaction().commit();


        }
    }
}

package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Some name", 30);
            session.save(person);



            //update
//          person.setName("New name");

            //delete
//          session.delete(person);

            session.getTransaction().commit();

            System.out.println(person.getId());


        } finally {
            sessionFactory.close();
        }
    }
}

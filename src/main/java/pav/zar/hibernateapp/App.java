package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Person;

import java.util.List;

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

//            Person person1 = new Person("Tom",35);
//            Person person2 = new Person("Mike",44);
//            Person person3 = new Person("Rob",55);
//            Person person4 = new Person("Bob",12);
//
//
//            session.save(person1);
//            session.save(person2);
//            session.save(person3);
//            session.save(person4);

            //List<Person> personList = session.createQuery("FROM Person where name like 'T%'").getResultList();

//            for(Person person : personList){
//                System.out.println(person);
//            }

//            session.createQuery("update Person set name = 'Tom' where age > 30").executeUpdate();
            session.createQuery("delete Person where age > 30").executeUpdate();

            //update
//          person.setName("New name");

            //delete
//          session.delete(person);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Item;
import pav.zar.hibernateapp.model.Person;

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

//            Person person = session.get(Person.class, 3);
//
//            List<Item> items = person.getItems();
//
//            for(Item item : items){
//                System.out.println(item.getItemName());
//                System.out.println(item.getOwner().getName());
//                System.out.println(item.getId());
//            }

            Item item = session.get(Item.class,5);
            Person person = item.getOwner();

            System.out.println(person.getName());

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

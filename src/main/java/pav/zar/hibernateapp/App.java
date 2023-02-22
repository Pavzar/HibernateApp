package pav.zar.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pav.zar.hibernateapp.model.Director;
import pav.zar.hibernateapp.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = session.get(Director.class,3);
            List<Movie> movies = director.getFilms();
            System.out.println(movies);

            Movie movie = session.get(Movie.class, 2);
            Director director1 = movie.getDirector();
            System.out.println(director1);


            Director QT = session.get(Director.class, 1);
            Movie newMovie = new Movie(QT, "Kill Bill", 2003);
            QT.getFilms().add(newMovie);

            session.save(newMovie);

            Director newDirectorTomBoberson = new Director("Tom Boberson",32);
            session.save(newDirectorTomBoberson);

            Movie newMovieTomBoberson = new Movie(newDirectorTomBoberson, "TestFilm", 2023);
            session.save(newMovieTomBoberson);

            newDirectorTomBoberson.setFilms(new ArrayList<>(Collections.singleton(newMovieTomBoberson)));

            System.out.println(newDirectorTomBoberson.getFilms());
            System.out.println(newMovieTomBoberson.getDirector());

            Movie changeMovie = session.get(Movie.class, 26);
            changeMovie.setDirector(session.get(Director.class, 1));
            session.save(changeMovie);

            Director d = session.get(Director.class, 1);
            System.out.println(d.getFilms());

            session.remove(d.getFilms().get(1));

            for(Movie movie1 : d.getFilms()){
                System.out.println(movie1.getMovieName());

            }
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}

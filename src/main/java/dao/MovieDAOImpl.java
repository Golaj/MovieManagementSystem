package dao;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Movie;

@RequestScoped
public class MovieDAOImpl{

    @PersistenceContext
    EntityManager em;

//    @Override
    public void addThing(Movie t) {
        em.persist(t);
    }

//    @Override
    public Movie getOneThing(Long id) {
        return em.find(Movie.class, id);
    }

//    @Override
    public List<Movie> getAllThings() {
        return em.createQuery("SELECT m FROM Movie m").getResultList();
    }

//    @Override
    public void editThing(Movie t) {
        em.merge(t);
    }

//    @Override
    public void removeThing(Long id) {
        em.remove(em.find(Movie.class, id));
    }

}

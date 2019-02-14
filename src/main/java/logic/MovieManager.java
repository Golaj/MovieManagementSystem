package logic;

import dao.GenericDAO;
import dao.MovieDAOImpl;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Movie;

@Stateless
public class MovieManager {

    @Inject
    MovieDAOImpl dao;

    public void addMovie(Movie m) {
        dao.addThing(m);
    }

    public Movie getMovie(Long id) {
        return dao.getOneThing(id);
    }

    public List<Movie> getAllMovies() {
        return dao.getAllThings();
    }

    public void editMovie(Movie m) {
        dao.editThing(m);
    }

    public void removeMovie(Long id) {
        dao.removeThing(id);
    }

    public void setDao(MovieDAOImpl dao) {
        this.dao = dao;
    }

}

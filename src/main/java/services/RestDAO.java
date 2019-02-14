package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logic.MovieManager;
import model.Movie;

@Stateless
@Path("entity/movie")
public class RestDAO {

    @Inject
    MovieManager mm;
    
    public RestDAO(){
        
    }
    
    public RestDAO(MovieManager mm){
        this.mm = mm;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addMovie(Movie m) {
        mm.addMovie(m);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie getMovie(@PathParam("id") Long id) {
        return mm.getMovie(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> getAllMovies() {
        return mm.getAllMovies();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editMovie(Movie m) {
        mm.editMovie(m);
    }

    @DELETE
    @Path("{id}")
    public void removeMovie(@PathParam("id") Long id) {
        mm.removeMovie(id);
    }

}

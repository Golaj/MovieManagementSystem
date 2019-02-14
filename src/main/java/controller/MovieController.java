package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import logic.MovieManager;
import model.Movie;


@Named(value = "movieController")
@RequestScoped
public class MovieController {
    
    @Inject
    MovieManager mm;
    
    private String name;
    private String mainActor;
    private Integer runtime;
    private List<Movie> allMovies;
    
    public MovieController() {
    }
    
    public void submit(){
        Movie m = new Movie(name, mainActor, runtime);
        mm.addMovie(m);
        allMovies = mm.getAllMovies();
    }

    @PostConstruct
    public void fillArray(){
        allMovies = mm.getAllMovies();
    }

    public MovieManager getMm() {
        return mm;
    }

    public void setMm(MovieManager mm) {
        this.mm = mm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }
    
    

}
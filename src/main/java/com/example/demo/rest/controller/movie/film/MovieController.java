package com.example.demo.rest.controller.movie.film;

import com.example.demo.rest.model.movie.film.MovieRequestModel;
import com.example.demo.rest.model.movie.film.MovieResponseModel;
import com.example.demo.service.movie.film.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/movie")
    public ResponseEntity<MovieResponseModel> create(@RequestBody MovieRequestModel movie){
        LOGGER.info("Request to create movie - {}",movie);
        MovieResponseModel createMovie = movieService.create(movie);
        LOGGER.info("Response of: movie successfully created - {}",createMovie);
        return ResponseEntity.ok(createMovie);
    }

    @GetMapping(value = "/movie")
    public ResponseEntity<List<MovieResponseModel>> selectAllMovies(){
        LOGGER.info("Request to select all movies");
        List<MovieResponseModel> movies = movieService.selectAllMovies();
        LOGGER.info("Response of: all movies successfully selected - {}",movies);
        return ResponseEntity.ok(movies);
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<MovieResponseModel> findMovieById(@PathVariable Long id){
        LOGGER.info("Request to find movie by id - {}",id);
        MovieResponseModel movie = movieService.findMovieById(id);
        LOGGER.info("Response of: movie successfully be find by id - {}",movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping(value = "/movie/{id}")
    public ResponseEntity<MovieResponseModel> update(@PathVariable Long id,@RequestBody MovieRequestModel movie){
        LOGGER.info("Request to update movie by id - {} - {}",id,movie);
        MovieResponseModel updateMovie = movieService.update(id, movie);
        LOGGER.info("Response of: movie successfully updated by id - {}",updateMovie);
        return ResponseEntity.ok(updateMovie);
    }

    @DeleteMapping(value = "/movie/{id}")
    public void delete(@PathVariable Long id){
        LOGGER.info("Request to delete movie by id - {}",id);
        movieService.delete(id);
        LOGGER.info("Response of: movie successfully deleted");
    }

    @GetMapping(value = "/movie/search/{name}")
    public ResponseEntity<List<MovieResponseModel>> search(@PathVariable String name){
        LOGGER.info("Request to search movie by name - {}",name);
        List<MovieResponseModel> movies = movieService.search(name);
        LOGGER.info("Response of: movie successfully be find by name - {}",movies);
        return ResponseEntity.ok(movies);
    }
}

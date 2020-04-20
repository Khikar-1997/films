package com.example.demo.persistance.repository.movie.film;

import com.example.demo.persistance.model.movie.film.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query(value = "select u from Movie u where u.name like ?1%")
    List<Movie> searchByNameStartsWith(String name);
}

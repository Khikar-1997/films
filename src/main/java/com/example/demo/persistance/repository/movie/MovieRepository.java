package com.example.demo.persistance.repository.movie;

import com.example.demo.persistance.model.movie.film.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}

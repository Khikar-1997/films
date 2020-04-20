package com.example.demo.persistance.repository.movie.personal;

import com.example.demo.persistance.model.movie.personal.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
}

package com.example.demo.persistance.repository.trailer;

import com.example.demo.persistance.model.movie.trailer.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer,Long> {
}

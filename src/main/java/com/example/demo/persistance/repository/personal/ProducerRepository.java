package com.example.demo.persistance.repository.personal;

import com.example.demo.persistance.model.movie.personal.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {
}

package com.example.demo.persistance.repository.personal;

import com.example.demo.persistance.model.movie.personal.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}

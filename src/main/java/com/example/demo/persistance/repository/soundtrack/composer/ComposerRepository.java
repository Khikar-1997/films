package com.example.demo.persistance.repository.soundtrack.composer;

import com.example.demo.persistance.model.movie.soundtrack.composer.Composer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposerRepository extends JpaRepository<Composer,Long> {
}

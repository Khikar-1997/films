package com.example.demo.persistance.repository.movie.soundtrack.music;

import com.example.demo.persistance.model.movie.soundtrack.music.Soundtrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundtrackRepository extends JpaRepository<Soundtrack,Long> {
}

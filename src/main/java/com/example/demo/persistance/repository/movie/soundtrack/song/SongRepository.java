package com.example.demo.persistance.repository.movie.soundtrack.song;

import com.example.demo.persistance.model.movie.soundtrack.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
}

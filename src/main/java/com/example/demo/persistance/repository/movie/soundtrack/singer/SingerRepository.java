package com.example.demo.persistance.repository.movie.soundtrack.singer;

import com.example.demo.persistance.model.movie.soundtrack.singer.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {
}

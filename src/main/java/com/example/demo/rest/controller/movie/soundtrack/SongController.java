package com.example.demo.rest.controller.movie.soundtrack;

import com.example.demo.rest.model.movie.soundtrack.song.SongRequestModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongResponseModel;
import com.example.demo.service.movie.soundtrack.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SongController.class);

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping(value = "/song")
    public ResponseEntity<SongResponseModel> create(@RequestBody SongRequestModel song) {
        LOGGER.info("Requset to create song - {}", song);
        SongResponseModel createSong = songService.create(song);
        LOGGER.info("Response of: create song - {}", createSong);
        return ResponseEntity.ok(createSong);
    }

    @GetMapping(value = "/song")
    public ResponseEntity<List<SongResponseModel>> selectAllSongs() {
        LOGGER.info("Request to select all songs");
        List<SongResponseModel> songs = songService.selectAllSongs();
        LOGGER.info("Response of: select all songs - {}", songs);
        return ResponseEntity.ok(songs);
    }

    @GetMapping(value = "/song/{id}")
    public ResponseEntity<SongResponseModel> findSongById(@PathVariable Long id) {
        LOGGER.info("Request to find song by id - {}", id);
        SongResponseModel song = songService.findSongById(id);
        LOGGER.info("Response of: find song by id - {}", song);
        return ResponseEntity.ok(song);
    }

    @PutMapping(value = "/song/{id}")
    public ResponseEntity<SongResponseModel> update(@PathVariable Long id, @RequestBody SongRequestModel song) {
        LOGGER.info("Request to update song by id - {} - {}", id, song);
        SongResponseModel updateSong = songService.update(id, song);
        LOGGER.info("Response of: update song by id - {}", updateSong);
        return ResponseEntity.ok(updateSong);
    }

    @DeleteMapping(value = "/song/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Request to delete song by id - {}", id);
        songService.delete(id);
        LOGGER.info("Song successfully deleted");
    }
}
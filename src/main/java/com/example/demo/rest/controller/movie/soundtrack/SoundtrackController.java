package com.example.demo.rest.controller.movie.soundtrack;

import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackRequestModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackResponseModel;
import com.example.demo.service.movie.soundtrack.SoundtrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoundtrackController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SoundtrackController.class);

    private final SoundtrackService soundtrackService;

    public SoundtrackController(SoundtrackService soundtrackService) {
        this.soundtrackService = soundtrackService;
    }

    @PostMapping(value = "/soundtrack")
    public ResponseEntity<SoundtrackResponseModel> create(@RequestBody SoundtrackRequestModel soundtrack) {
        LOGGER.info("Request to create soundtrack - {}", soundtrack);
        SoundtrackResponseModel createSoundtrack = soundtrackService.create(soundtrack);
        LOGGER.info("Response of: create soundtrack");
        return ResponseEntity.ok(createSoundtrack);
    }

    @GetMapping(value = "/soundtrack")
    public ResponseEntity<List<SoundtrackResponseModel>> selectAllSoundtracks() {
        LOGGER.info("Request to select all soundtracks");
        List<SoundtrackResponseModel> soundtracks = soundtrackService.selectAllSoundtracks();
        LOGGER.info("Response of: select all soundtracks - {}", soundtracks);
        return ResponseEntity.ok(soundtracks);
    }

    @GetMapping(value = "/soundtrack/{id}")
    public ResponseEntity<SoundtrackResponseModel> findSoundtrackById(@PathVariable Long id) {
        LOGGER.info("Request to find soundtrack by id - {}", id);
        SoundtrackResponseModel soundtrack = soundtrackService.findSoundtrackById(id);
        LOGGER.info("Response of: find soundtrack by id - {}", soundtrack);
        return ResponseEntity.ok(soundtrack);
    }

    @PutMapping(value = "/soundtrack/{id}")
    public ResponseEntity<SoundtrackResponseModel> update(@PathVariable Long id, @RequestBody SoundtrackRequestModel soundtrack) {
        LOGGER.info("Request to update soundtrack by id - {} -{}", id, soundtrack);
        SoundtrackResponseModel updateSoundtrack = soundtrackService.update(id, soundtrack);
        LOGGER.info("Response of: update soundtrack by id - {}", updateSoundtrack);
        return ResponseEntity.ok(updateSoundtrack);
    }

    @DeleteMapping(value = "/soundtrack/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Request to delete soundtrack by id - {}", id);
        soundtrackService.delete(id);
        LOGGER.info("Soundtrack successfully deleted");
    }
}
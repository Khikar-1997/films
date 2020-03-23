package com.example.demo.rest.controller.movie.personal;

import com.example.demo.rest.model.movie.personal.director.DirectorRequestModel;
import com.example.demo.rest.model.movie.personal.director.DirectorResponseModel;
import com.example.demo.service.movie.personal.DirectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorController.class);

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping(value = "/director")
    public ResponseEntity<DirectorResponseModel> create(@RequestBody DirectorRequestModel director) {
        LOGGER.info("Request to create director - {}", director);
        DirectorResponseModel createDirector = directorService.create(director);
        LOGGER.info("Response of: create director - {}", createDirector);
        return ResponseEntity.ok(createDirector);
    }

    @GetMapping(value = "/director")
    public ResponseEntity<List<DirectorResponseModel>> selectAllDirectors() {
        LOGGER.info("Request to select all directors");
        List<DirectorResponseModel> allDirectors = directorService.selectAllDirectors();
        LOGGER.info("Response of: select all directors - {}", allDirectors);
        return ResponseEntity.ok(allDirectors);
    }

    @GetMapping(value = "/director/{id}")
    public ResponseEntity<DirectorResponseModel> findDirectorById(@PathVariable Long id) {
        LOGGER.info("Request to find director by id - {}", id);
        DirectorResponseModel director = directorService.findDirectorById(id);
        LOGGER.info("Response of: find director by id - {}", director);
        return ResponseEntity.ok(director);
    }

    @PutMapping(value = "/director/{id}")
    public ResponseEntity<DirectorResponseModel> update(@PathVariable Long id, @RequestBody DirectorRequestModel director) {
        LOGGER.info("Request to update director by id - {} - {}", id, director);
        DirectorResponseModel updateDirector = directorService.update(id, director);
        LOGGER.info("Response of: update director by id - {}", updateDirector);
        return ResponseEntity.ok(updateDirector);
    }

    @DeleteMapping(value = "/director/{id}")
    public void delete(@RequestBody Long id) {
        LOGGER.info("Request to delete director by id - {}", id);
        directorService.delete(id);
        LOGGER.info("Director successfully deleted");
    }
}
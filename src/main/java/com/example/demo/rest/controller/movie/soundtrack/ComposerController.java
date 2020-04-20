package com.example.demo.rest.controller.movie.soundtrack;

import com.example.demo.rest.model.movie.soundtrack.composer.ComposerRequestModel;
import com.example.demo.rest.model.movie.soundtrack.composer.ComposerResponseModel;
import com.example.demo.service.movie.soundtrack.ComposerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComposerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ComposerController.class);

    private final ComposerService composerService;

    public ComposerController(ComposerService composerService) {
        this.composerService = composerService;
    }

    @PostMapping(value = "/composer")
    public ResponseEntity<ComposerResponseModel> create(@RequestBody ComposerRequestModel composer) {
        LOGGER.info("Request to create composer - {}", composer);
        ComposerResponseModel createComposer = composerService.create(composer);
        LOGGER.info("Response of: composer successfully created - {}", createComposer);
        return ResponseEntity.ok(createComposer);
    }

    @GetMapping(value = "/composer")
    public ResponseEntity<List<ComposerResponseModel>> selectAllComposers() {
        LOGGER.info("Request to select all composers");
        List<ComposerResponseModel> composers = composerService.selectAllComposers();
        LOGGER.info("Response of: all composers successfully selected - {}", composers);
        return ResponseEntity.ok(composers);
    }

    @GetMapping(value = "/composer/{id}")
    public ResponseEntity<ComposerResponseModel> findComposerById(@PathVariable Long id) {
        LOGGER.info("Request to find composer by id - {}", id);
        ComposerResponseModel composer = composerService.findComposerById(id);
        LOGGER.info("Response of: composer successfully be find by id - {}", composer);
        return ResponseEntity.ok(composer);
    }

    @PutMapping(value = "/composer/{id}")
    public ResponseEntity<ComposerResponseModel> update(@RequestBody ComposerRequestModel composer, @PathVariable Long id) {
        LOGGER.info("Request to update composer by id - {} - {}", id, composer);
        ComposerResponseModel updateComposer = composerService.update(id, composer);
        LOGGER.info("Response of: composer successfully updated by id - {}", updateComposer);
        return ResponseEntity.ok(updateComposer);
    }

    @DeleteMapping(value = "/composer/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Request to delete composer by id - {}", id);
        composerService.delete(id);
        LOGGER.info("Response of: composer successfully deleted");
    }
}
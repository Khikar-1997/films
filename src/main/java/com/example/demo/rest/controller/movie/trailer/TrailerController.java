package com.example.demo.rest.controller.movie.trailer;

import com.example.demo.rest.model.movie.trailer.TrailerRequestModel;
import com.example.demo.rest.model.movie.trailer.TrailerResponseModel;
import com.example.demo.service.movie.trailer.TrailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrailerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TrailerController.class);

    private final TrailerService trailerService;

    public TrailerController(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @PostMapping(value = "/trailer")
    public ResponseEntity<TrailerResponseModel> create(@RequestBody TrailerRequestModel trailer) {
        LOGGER.info("Request to create trailer - {}", trailer);
        TrailerResponseModel createTrailer = trailerService.create(trailer);
        LOGGER.info("Response of: trailer successfully created - {}", createTrailer);
        return ResponseEntity.ok(createTrailer);
    }

    @GetMapping(value = "/trailer")
    public ResponseEntity<List<TrailerResponseModel>> selectAllTrailers() {
        LOGGER.info("Request to select all trailers");
        List<TrailerResponseModel> trailers = trailerService.selectAllTrailers();
        LOGGER.info("Response of: all trailers successfully selected - {}", trailers);
        return ResponseEntity.ok(trailers);
    }

    @GetMapping(value = "/trailer/{id}")
    public ResponseEntity<TrailerResponseModel> findTrailerById(@PathVariable Long id) {
        LOGGER.info("Request to find trailer by id - {}", id);
        TrailerResponseModel trailer = trailerService.findTrailerById(id);
        LOGGER.info("Response of: trailer successfully be find by id - {}", trailer);
        return ResponseEntity.ok(trailer);
    }

    @PutMapping(value = "/trailer/{id}")
    public ResponseEntity<TrailerResponseModel> update(@PathVariable Long id, @RequestBody TrailerRequestModel trailer) {
        LOGGER.info("Request to update trailer by id - {} - {}", id, trailer);
        TrailerResponseModel updateTrailer = trailerService.update(id, trailer);
        LOGGER.info("Response of: trailer successfully updated by id - {}", updateTrailer);
        return ResponseEntity.ok(updateTrailer);
    }

    @DeleteMapping(value = "/trailer/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Request to delete trailer by id - {}", id);
        trailerService.delete(id);
        LOGGER.info("Response of: trailer successfully deleted");
    }
}
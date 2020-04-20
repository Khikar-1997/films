package com.example.demo.rest.controller.movie.soundtrack;

import com.example.demo.rest.model.movie.soundtrack.singer.SingerRequestModel;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;
import com.example.demo.service.movie.soundtrack.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public class SingerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(SingerController.class);

    private final SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    @PostMapping(value = "/singer")
    public ResponseEntity<SingerResponseModel> create(@RequestBody SingerRequestModel singer) {
        LOGGER.info("Request to create singer - {}", singer);
        SingerResponseModel createSinger = singerService.create(singer);
        LOGGER.info("Response of: singer successfully created - {}", createSinger);
        return ResponseEntity.ok(createSinger);
    }

    @GetMapping(value = "/singer")
    public ResponseEntity<List<SingerResponseModel>> selectAllSingers() {
        LOGGER.info("Request to select all singers");
        List<SingerResponseModel> singers = singerService.selectAllSingers();
        LOGGER.info("Response of: all singers successfully selected - {}", singers);
        return ResponseEntity.ok(singers);
    }

    @GetMapping(value = "/singer/{id}")
    public ResponseEntity<SingerResponseModel> findSingerById(@PathVariable Long id) {
        LOGGER.info("Request to find singer by id - {}", id);
        SingerResponseModel singer = singerService.findSingerById(id);
        LOGGER.info("Response of: singer successfully be find by id - {}", singer);
        return ResponseEntity.ok(singer);
    }

    @PutMapping(value = "/singer/{id}")
    public ResponseEntity<SingerResponseModel> update(@PathVariable Long id, @RequestBody SingerRequestModel singer) {
        LOGGER.info("Request to update singer by id - {} - {}", id, singer);
        SingerResponseModel updateSinger = singerService.update(id, singer);
        LOGGER.info("Response of: singer successfully updated by id - {}", updateSinger);
        return ResponseEntity.ok(updateSinger);
    }

    @DeleteMapping(value = "/singer/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Request to delete singer by id");
        singerService.delete(id);
        LOGGER.info("Response of: singer successfully deleted");
    }
}
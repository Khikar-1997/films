package com.example.demo.rest.controller.movie.personal;

import com.example.demo.rest.model.movie.personal.producer.ProducerRequestModel;
import com.example.demo.rest.model.movie.personal.producer.ProducerResponseModel;
import com.example.demo.service.movie.personal.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProducerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/producer")
    public ResponseEntity<ProducerResponseModel> create(@RequestBody ProducerRequestModel producer){
        LOGGER.info("Request to create producer - {}",producer);
        ProducerResponseModel createProducer = producerService.create(producer);
        LOGGER.info("Response of: producer successfully created - {}",createProducer);
        return ResponseEntity.ok(createProducer);
    }

    @GetMapping(value = "/producer")
    public ResponseEntity<List<ProducerResponseModel>> selectAllProducers(){
        LOGGER.info("Request to select all producers");
        List<ProducerResponseModel> producers = producerService.selectAllProducers();
        LOGGER.info("Response of: all producers successfully selected - {}",producers);
        return ResponseEntity.ok(producers);
    }

    @GetMapping(value = "/producer/{id}")
    public ResponseEntity<ProducerResponseModel> findProducerById(@PathVariable Long id){
        LOGGER.info("Request to find producer by id - {}",id);
        ProducerResponseModel producer = producerService.findProducerById(id);
        LOGGER.info("Response of: producer successfully be find by id - {}",producer);
        return ResponseEntity.ok(producer);
    }

    @PutMapping(value = "/producer/{id}")
    public ResponseEntity<ProducerResponseModel> update(@PathVariable Long id,@RequestBody ProducerRequestModel producer){
        LOGGER.info("Request to update producer by id - {} - {}",id,producer);
        ProducerResponseModel updateProducer = producerService.update(id, producer);
        LOGGER.info("Response of: producer successfully updated by id - {}",updateProducer);
        return ResponseEntity.ok(updateProducer);
    }

    @DeleteMapping(value = "/producer/{id}")
    public void delete(@PathVariable Long id){
        LOGGER.info("Request to delete producer by id - {}",id);
        producerService.delete(id);
        LOGGER.info("Response of: producer successfully deleted");
    }
}

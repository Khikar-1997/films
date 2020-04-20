package com.example.demo.rest.controller.movie.personal;

import com.example.demo.rest.model.movie.personal.actor.ActorRequestModel;
import com.example.demo.rest.model.movie.personal.actor.ActorResponseModel;
import com.example.demo.service.movie.personal.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ActorController.class);

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping(value = "/actor")
    public ResponseEntity<ActorResponseModel> create(@RequestBody ActorRequestModel actor){
        LOGGER.info("Request to create actor - {}",actor);
        ActorResponseModel createActor = actorService.create(actor);
        LOGGER.info("Response of: actor successfully created - {}",createActor);
        return ResponseEntity.ok(createActor);
    }

    @GetMapping(value = "/actor")
    public ResponseEntity<List<ActorResponseModel>> selectAllActors(){
        LOGGER.info("Request to select all actors");
        List<ActorResponseModel> actors = actorService.selectAllActors();
        LOGGER.info("Response of: all actors successfully selected - {}",actors);
        return ResponseEntity.ok(actors);
    }

    @GetMapping(value = "/actor/{id}")
    public ResponseEntity<ActorResponseModel> findActorById(@PathVariable Long id){
        LOGGER.info("Request to find actor by id - {}",id);
        ActorResponseModel actor = actorService.findActorById(id);
        LOGGER.info("Response of: actor successfully be find by id - {}",actor);
        return ResponseEntity.ok(actor);
    }

    @PutMapping(value = "/actor/{id}")
    public ResponseEntity<ActorResponseModel> update(@PathVariable Long id,@RequestBody ActorRequestModel actor){
        LOGGER.info("Request to update actor by id - {} - {}",id,actor);
        ActorResponseModel updateActor = actorService.update(id,actor);
        LOGGER.info("Response of: actor successfully updated by id - {}",updateActor);
        return ResponseEntity.ok(updateActor);
    }

    @DeleteMapping(value = "/actor/{id}")
    public void delete(@PathVariable Long id){
        LOGGER.info("Request to delete actor by id - {}",id);
        actorService.delete(id);
        LOGGER.info("Response of: actor successfully deleted ");
    }
}

package com.example.demo.service.movie.personal;

import com.example.demo.exception.ActorNotFoundException;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.repository.movie.film.MovieRepository;
import com.example.demo.persistance.repository.movie.personal.ActorRepository;
import com.example.demo.rest.model.movie.personal.actor.ActorRequestModel;
import com.example.demo.rest.model.movie.personal.actor.ActorResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorService.class);

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
    }

    //region public Methods

    public ActorResponseModel create(ActorRequestModel actorRequestModel){
        LOGGER.info("Request to create actor - {}",actorRequestModel);
        Actor actor = buildActorFrom(actorRequestModel);
        Actor createActor = actorRepository.save(actor);
        ActorResponseModel actorResponseModel = buildActorResponseModelFrom(createActor);
        LOGGER.info("Actor successfully created - {}",actorResponseModel);
        return actorResponseModel;
    }

    public List<ActorResponseModel> selectAllActors(){
        LOGGER.info("Request to select all authors");
        List<Actor> actors = actorRepository.findAll();
        List<ActorResponseModel> collect = actors.stream()
                .map(this::buildActorResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All actors successfully selected - {}",collect);
        return collect;
    }

    public ActorResponseModel findActorById(Long id){
        LOGGER.info("Request to find actor by id - {}",id);
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.format("Actor not found for id - {}%d",id)));
        ActorResponseModel actorResponseModel = buildActorResponseModelFrom(actor);
        LOGGER.info("Actor successfully be find by id - {}",actorResponseModel);
        return actorResponseModel;
    }

    public ActorResponseModel update(Long id,ActorRequestModel actorRequestModel){
        LOGGER.info("Request to update actor by id - {} - {}",id,actorRequestModel);
        Actor actorById = actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(String.format("Actor not found for id - {}%d",id)));
        actorById.setAge(actorRequestModel.getAge());
        actorById.setName(actorRequestModel.getName());
        actorById.setSurname(actorRequestModel.getSurname());
        actorById.setProfession(actorById.getProfession());
        Actor updateActor = actorRepository.save(actorById);
        ActorResponseModel actorResponseModel = buildActorResponseModelFrom(updateActor);
        LOGGER.info("Actor successfully updated by id - {}",actorResponseModel);
        return actorResponseModel;
    }

    public void delete(Long id){
        LOGGER.info("Request to delete actor by id - {}",id);
        actorRepository.deleteById(id);
        LOGGER.info("Actor successfully deleted");
    }

    //endregion

    //region private Methods

    private Actor buildActorFrom(ActorRequestModel actorRequestModel){
        Actor actor = new Actor();
        actor.setName(actorRequestModel.getName());
        actor.setSurname(actorRequestModel.getSurname());
        actor.setAge(actorRequestModel.getAge());
        actor.setProfession(actorRequestModel.getProfession());
        return actor;
    }

    private ActorResponseModel buildActorResponseModelFrom(Actor actor){
        ActorResponseModel actorResponseModel = new ActorResponseModel();
        actorResponseModel.setId(actor.getId());
        actorResponseModel.setName(actor.getName());
        actorResponseModel.setSurname(actor.getSurname());
        actorResponseModel.setAge(actor.getAge());
        actorResponseModel.setProfession(actor.getProfession());
        return actorResponseModel;
    }

    //endregion
}

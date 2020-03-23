package com.example.demo.service.movie.personal;

import com.example.demo.persistance.model.movie.film.Movie;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.repository.movie.MovieRepository;
import com.example.demo.persistance.repository.personal.ActorRepository;
import com.example.demo.rest.model.movie.film.MovieResponseModel;
import com.example.demo.rest.model.movie.personal.actor.ActorRequestModel;
import com.example.demo.rest.model.movie.personal.actor.ActorResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActorService.class);

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

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
        Movie movie = new Movie();
        MovieResponseModel movieResponseModel = new MovieResponseModel();
        movieResponseModel.setId(movie.getId());
        movieResponseModel.setName(movie.getName());
        return actorResponseModel;
    }
    //endregion
}

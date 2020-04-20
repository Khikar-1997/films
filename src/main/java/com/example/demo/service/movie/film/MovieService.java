package com.example.demo.service.movie.film;

import com.example.demo.exception.*;
import com.example.demo.persistance.model.movie.film.Movie;
import com.example.demo.persistance.model.movie.personal.actor.Actor;
import com.example.demo.persistance.model.movie.personal.director.Director;
import com.example.demo.persistance.model.movie.personal.producer.Producer;
import com.example.demo.persistance.model.movie.soundtrack.music.Soundtrack;
import com.example.demo.persistance.model.movie.soundtrack.song.Song;
import com.example.demo.persistance.model.movie.trailer.Trailer;
import com.example.demo.persistance.repository.movie.film.MovieRepository;
import com.example.demo.persistance.repository.movie.personal.ActorRepository;
import com.example.demo.persistance.repository.movie.personal.DirectorRepository;
import com.example.demo.persistance.repository.movie.personal.ProducerRepository;
import com.example.demo.persistance.repository.movie.soundtrack.music.SoundtrackRepository;
import com.example.demo.persistance.repository.movie.trailer.TrailerRepository;
import com.example.demo.rest.model.movie.film.MovieRequestModel;
import com.example.demo.rest.model.movie.film.MovieResponseModel;
import com.example.demo.rest.model.movie.personal.director.DirectorResponseModel;
import com.example.demo.rest.model.movie.soundtrack.composer.ComposerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackResponseModel;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongResponseModel;
import com.example.demo.rest.model.movie.trailer.TrailerResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final ProducerRepository producerRepository;
    private final SoundtrackRepository soundtrackRepository;
    private final TrailerRepository trailerRepository;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, DirectorRepository directorRepository, ProducerRepository producerRepository, SoundtrackRepository soundtrackRepository, TrailerRepository trailerRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.producerRepository = producerRepository;
        this.soundtrackRepository = soundtrackRepository;
        this.trailerRepository = trailerRepository;
    }

    //region public Methods

    public MovieResponseModel create(MovieRequestModel movieRequestModel){
        LOGGER.info("Request to create movie - {}",movieRequestModel);
        Movie movie =buildMovieFrom(movieRequestModel);
        Actor actorById = actorRepository.findById(movieRequestModel.getActorId())
                .orElseThrow(() -> new ActorNotFoundException(String.format("Actor not found for id - {}%d",movieRequestModel.getActorId())));
        movie.getActors().add(actorById);
        Producer producerById = producerRepository.findById(movieRequestModel.getProducerId())
                .orElseThrow(() -> new ProducerNotFoundException(String.format("Producer not found for id - {}%d",movieRequestModel.getProducerId())));
        movie.getProducers().add(producerById);
        Director directorById = directorRepository.findById(movieRequestModel.getDirectorId())
                .orElseThrow(() -> new DirectorNotFoundException(String.format("Director not found for id - {}%d",movieRequestModel.getDirectorId())));
        movie.setDirector(directorById);
        Trailer trailerById = trailerRepository.findById(movieRequestModel.getTrailerId())
                .orElseThrow(() -> new TrailerNotFoundException(String.format("Trailer not found for id - {}%d",movieRequestModel.getTrailerId())));
        movie.setTrailer(trailerById);
        Soundtrack soundtrackById = soundtrackRepository.findById(movieRequestModel.getSoundtrackId())
                .orElseThrow(() -> new SoundtrackNotFoundException(String.format("Soundtrack not found for id - {}%d",movieRequestModel.getSoundtrackId())));
        movie.setSoundtrack(soundtrackById);
        Movie createMovie = movieRepository.save(movie);
        MovieResponseModel movieResponseModel = buildMovieResponseModelFrom(createMovie);
        LOGGER.info("Movie successfully created - {}",movieResponseModel);
        return movieResponseModel;
    }

    public List<MovieResponseModel> selectAllMovies(){
        LOGGER.info("Request to select all movies");
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponseModel> collect = movies.stream()
                .map(this::buildMovieResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All movies successfully selected - {}",collect);
        return collect;
    }

    public MovieResponseModel findMovieById(Long id){
        LOGGER.info("Request to find movie by id - {}",id);
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(String.format("Movie not found for id - {}%d",id)));
        MovieResponseModel movieResponseModel = buildMovieResponseModelFrom(movie);
        LOGGER.info("Movie successfully be find - {}",movieResponseModel);
        return movieResponseModel;
    }

    public MovieResponseModel update(Long id,MovieRequestModel movieRequestModel){
        LOGGER.info("Request to update movie by id - {} - {}",id,movieRequestModel);
        Movie movieById = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(String.format("Movie not found for id - {}%d",id)));
        movieById.setName(movieRequestModel.getName());
        movieById.setGenre(movieRequestModel.getGenre());
        movieById.setDuration(movieRequestModel.getDuration());
        Actor actor = actorRepository.findById(movieRequestModel.getActorId())
                .orElseThrow(() -> new ActorNotFoundException(String.format("Actor not found for id - {}%d",movieRequestModel.getActorId())));
        movieById.getActors().add(actor);
        Director director = directorRepository.findById(movieRequestModel.getDirectorId())
                .orElseThrow(() -> new DirectorNotFoundException(String.format("Director not found for id - {}%d",movieRequestModel.getDirectorId())));
        movieById.setDirector(director);
        Producer producer = producerRepository.findById(movieRequestModel.getProducerId())
                .orElseThrow(() -> new ProducerNotFoundException(String.format("Producer not found for id - {}%d",movieRequestModel.getProducerId())));
        movieById.getProducers().add(producer);
        Soundtrack soundtrack = soundtrackRepository.findById(movieRequestModel.getSoundtrackId())
                .orElseThrow(() -> new SoundtrackNotFoundException(String.format("Soundtrack not found for id - {}%d",movieRequestModel.getSoundtrackId())));
        movieById.setSoundtrack(soundtrack);
        Trailer trailer = trailerRepository.findById(movieRequestModel.getTrailerId())
                .orElseThrow(() -> new TrailerNotFoundException(String.format("Trailer not found for id - {}%d",movieRequestModel.getTrailerId())));
        movieById.setTrailer(trailer);
        Movie updateMovie = movieRepository.save(movieById);
        MovieResponseModel movieResponseModel = buildMovieResponseModelFrom(updateMovie);
        LOGGER.info("Movie successfully updated by id - {}",movieResponseModel);
        return movieResponseModel;
    }

    public void delete(Long id){
        LOGGER.info("Request to delete movie by id - {}",id);
        movieRepository.deleteById(id);
        LOGGER.info("Movie successfully deleted");
    }

    public List<MovieResponseModel> search(String name){
        LOGGER.info("Request search movie by name - {}",name);
        List<Movie> movies = movieRepository.searchByNameStartsWith(name);
        List<MovieResponseModel> collect = movies.stream()
                .map(this::buildMovieResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("movie successfully be find by name - {}",collect);
        return collect;
    }

    //endregion

    //region private methods

    private Movie buildMovieFrom(MovieRequestModel movieRequestModel){
        Movie movie = new Movie();
        movie.setName(movieRequestModel.getName());
        movie.setDuration(movieRequestModel.getDuration());
        movie.setGenre(movieRequestModel.getGenre());
        return movie;
    }

    private MovieResponseModel buildMovieResponseModelFrom(Movie movie){
        MovieResponseModel movieResponseModel = new MovieResponseModel();
        movieResponseModel.setId(movie.getId());
        movieResponseModel.setName(movie.getName());
        movieResponseModel.setGenre(movie.getGenre());
        movieResponseModel.setDuration(movie.getDuration());

        Set<Actor> actors = movie.getActors();
        movieResponseModel.setActors(actors);

        Set<Producer> producers = movie.getProducers();
        movieResponseModel.setProducers(producers);

        DirectorResponseModel directorResponseModel = new DirectorResponseModel();
        directorResponseModel.setId(movie.getDirector().getId());
        directorResponseModel.setName(movie.getDirector().getName());
        directorResponseModel.setSurname(movie.getDirector().getSurname());
        directorResponseModel.setAge(movie.getDirector().getAge());
        directorResponseModel.setProfession(movie.getDirector().getProfession());
        movieResponseModel.setDirector(directorResponseModel);

        TrailerResponseModel trailerResponseModel = new TrailerResponseModel();
        trailerResponseModel.setId(movie.getTrailer().getId());
        trailerResponseModel.setDuration(movie.getTrailer().getDuration());
        movieResponseModel.setTrailer(trailerResponseModel);

        SoundtrackResponseModel soundtrackResponseModel = new SoundtrackResponseModel();
        soundtrackResponseModel.setId(movie.getSoundtrack().getId());
        soundtrackResponseModel.setDuration(movie.getSoundtrack().getDuration());

        Soundtrack soundtrack = movie.getSoundtrack();
        SongResponseModel songResponseModel = new SongResponseModel();
        songResponseModel.setId(soundtrack.getSong().getId());
        songResponseModel.setName(soundtrack.getSong().getName());
        songResponseModel.setDuration(soundtrack.getSong().getDuration());

        Song song = soundtrack.getSong();
        SingerResponseModel singerResponseModel = new SingerResponseModel();
        singerResponseModel.setId(song.getSinger().getId());
        singerResponseModel.setName(song.getSinger().getName());
        singerResponseModel.setSurname(song.getSinger().getSurname());
        songResponseModel.setSinger(singerResponseModel);
        soundtrackResponseModel.setSong(songResponseModel);

        ComposerResponseModel composerResponseModel = new ComposerResponseModel();
        composerResponseModel.setId(soundtrack.getComposer().getId());
        composerResponseModel.setName(soundtrack.getComposer().getName());
        composerResponseModel.setSurname(soundtrack.getComposer().getSurname());
        soundtrackResponseModel.setComposer(composerResponseModel);
        movieResponseModel.setSoundtrack(soundtrackResponseModel);
        return movieResponseModel;
    }

    //endregion
}

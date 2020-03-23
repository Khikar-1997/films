package com.example.demo.service.movie.personal;

import com.example.demo.exception.DirectorNotFoundException;
import com.example.demo.persistance.model.movie.personal.director.Director;
import com.example.demo.persistance.repository.personal.DirectorRepository;
import com.example.demo.rest.model.movie.personal.director.DirectorRequestModel;
import com.example.demo.rest.model.movie.personal.director.DirectorResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorService {
    private final static Logger LOGGER = LoggerFactory.getLogger(DirectorService.class);

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    //region public Methods
    public DirectorResponseModel create(DirectorRequestModel directorRequestModel) {
        LOGGER.info("Request to create director - {}", directorRequestModel);
        Director director = buildDirectorFrom(directorRequestModel);
        Director createDirector = directorRepository.save(director);
        DirectorResponseModel save = builDirectorResponseModelFrom(createDirector);
        LOGGER.info("Director successefully created - {}", save);
        return save;
    }

    public List<DirectorResponseModel> selectAllDirectors() {
        LOGGER.info("Request to select all directors");
        List<Director> directors = directorRepository.findAll();
        List<DirectorResponseModel> allDirectors = directors.stream()
                .map(this::builDirectorResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All directors successfully selected - {}", allDirectors);
        return allDirectors;
    }

    public DirectorResponseModel findDirectorById(Long id) {
        LOGGER.info("Request to find director by id - {}", id);
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new DirectorNotFoundException(String.format("Director not found for id - {}%d", id)));
        DirectorResponseModel directorResponseModel = builDirectorResponseModelFrom(director);
        LOGGER.info("Director successfully be find - {}", directorResponseModel);
        return directorResponseModel;
    }

    public DirectorResponseModel update(Long id, DirectorRequestModel directorRequestModel) {
        LOGGER.info("Request to update director by id - {} - {}", id, directorRequestModel);
        Director directorById = directorRepository.findById(id)
                .orElseThrow(() -> new DirectorNotFoundException(String.format("Director not found for id - {}%d", id)));
        directorById.setName(directorRequestModel.getName());
        directorById.setSurname(directorRequestModel.getSurname());
        directorById.setAge(directorRequestModel.getAge());
        directorById.setProfession(directorRequestModel.getProfession());
        Director updateDirector = directorRepository.save(directorById);
        DirectorResponseModel directorResponseModel = builDirectorResponseModelFrom(updateDirector);
        LOGGER.info("Director successfully updated - {}", directorResponseModel);
        return directorResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete director - {}", id);
        directorRepository.deleteById(id);
        LOGGER.info("Director successfully deleted");
    }
    //endregion

    //region private Methods
    private Director buildDirectorFrom(DirectorRequestModel directorRequestModel) {
        Director director = new Director();
        director.setName(directorRequestModel.getName());
        director.setSurname(directorRequestModel.getSurname());
        director.setAge(directorRequestModel.getAge());
        director.setProfession(directorRequestModel.getProfession());
        return director;
    }

    private DirectorResponseModel builDirectorResponseModelFrom(Director director) {
        DirectorResponseModel directorResponseModel = new DirectorResponseModel();
        directorResponseModel.setId(director.getId());
        directorResponseModel.setName(director.getName());
        directorResponseModel.setSurname(director.getSurname());
        directorResponseModel.setAge(director.getAge());
        directorResponseModel.setProfession(director.getProfession());
        return directorResponseModel;
    }
    //endregion

}
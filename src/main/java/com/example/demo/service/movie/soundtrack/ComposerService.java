package com.example.demo.service.movie.soundtrack;

import com.example.demo.exception.ComposerNotFoundException;
import com.example.demo.persistance.model.movie.soundtrack.composer.Composer;
import com.example.demo.persistance.repository.soundtrack.composer.ComposerRepository;
import com.example.demo.rest.model.movie.soundtrack.composer.ComposerRequestModel;
import com.example.demo.rest.model.movie.soundtrack.composer.ComposerResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComposerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ComposerService.class);

    private final ComposerRepository composerRepository;

    public ComposerService(ComposerRepository composerRepository) {
        this.composerRepository = composerRepository;
    }

    //region public Methods

    public ComposerResponseModel create(ComposerRequestModel composerRequestModel) {
        LOGGER.info("Request to create composer - {}", composerRequestModel);
        Composer composer = buildComposerFrom(composerRequestModel);
        Composer createComposer = composerRepository.save(composer);
        ComposerResponseModel composerResponseModel = buildComposerResponseModelFrom(createComposer);
        LOGGER.info("Composer successfully created - {}", composerResponseModel);
        return composerResponseModel;
    }

    public List<ComposerResponseModel> selectAllComposers() {
        LOGGER.info("Request to select all composers");
        List<Composer> composers = composerRepository.findAll();
        List<ComposerResponseModel> collect = composers.stream()
                .map(this::buildComposerResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All composers successfully selected - {}", collect);
        return collect;
    }

    public ComposerResponseModel findComposerById(Long id) {
        LOGGER.info("Request to find composer by id - {}", id);
        Composer composer = composerRepository.findById(id)
                .orElseThrow(() -> new ComposerNotFoundException(String.format("Composer not found for id - {}%d", id)));
        ComposerResponseModel composerResponseModel = buildComposerResponseModelFrom(composer);
        LOGGER.info("Composer successfully be find by id- {}", composerResponseModel);
        return composerResponseModel;
    }

    public ComposerResponseModel update(Long id, ComposerRequestModel composerRequestModel) {
        LOGGER.info("Request to update composer by id - {} - {}", id, composerRequestModel);
        Composer composerById = composerRepository.findById(id)
                .orElseThrow(() -> new ComposerNotFoundException(String.format("Composer not found for id - {}%d", id)));
        composerById.setName(composerRequestModel.getName());
        composerById.setSurname(composerRequestModel.getSurname());
        Composer updateComposer = composerRepository.save(composerById);
        ComposerResponseModel composerResponseModel = buildComposerResponseModelFrom(updateComposer);
        LOGGER.info("Composer successfully updated - {}", composerResponseModel);
        return composerResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete by id - {}", id);
        composerRepository.deleteById(id);
        LOGGER.info("Composer successfully deleted");
    }

    //endregion

    //region private Methods
    private Composer buildComposerFrom(ComposerRequestModel composerRequestModel) {
        Composer composer = new Composer();
        composer.setName(composerRequestModel.getName());
        composer.setSurname(composerRequestModel.getSurname());
        return composer;
    }

    private ComposerResponseModel buildComposerResponseModelFrom(Composer composer) {
        ComposerResponseModel composerResponseModel = new ComposerResponseModel();
        composerResponseModel.setId(composer.getId());
        composerResponseModel.setName(composer.getName());
        composerResponseModel.setSurname(composer.getSurname());
        return composerResponseModel;
    }
    //endregion

}
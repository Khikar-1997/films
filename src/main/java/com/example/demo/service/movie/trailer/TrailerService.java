package com.example.demo.service.movie.trailer;

import com.example.demo.exception.TrailerNotFoundException;
import com.example.demo.persistance.model.movie.trailer.Trailer;
import com.example.demo.persistance.repository.trailer.TrailerRepository;
import com.example.demo.rest.model.movie.trailer.TrailerRequestModel;
import com.example.demo.rest.model.movie.trailer.TrailerResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrailerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(TrailerService.class);

    private final TrailerRepository trailerRepository;

    public TrailerService(TrailerRepository trailerRepository) {
        this.trailerRepository = trailerRepository;
    }

    //region public Methods

    public TrailerResponseModel create(TrailerRequestModel trailerRequestModel) {
        LOGGER.info("Request to create trailer - {}", trailerRequestModel);
        Trailer trailer = buildTrailerFrom(trailerRequestModel);
        Trailer createTrailer = trailerRepository.save(trailer);
        TrailerResponseModel trailerResponseModel = buildTrailerResponseModelFrom(createTrailer);
        LOGGER.info("Trailer successfully created - {}", trailerResponseModel);
        return trailerResponseModel;
    }

    public List<TrailerResponseModel> selectAllTrailers() {
        LOGGER.info("Request to all trailers");
        List<Trailer> trailers = trailerRepository.findAll();
        List<TrailerResponseModel> collect = trailers.stream()
                .map(this::buildTrailerResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All trailers successfully selected - {}", collect);
        return collect;
    }

    public TrailerResponseModel findTrailerById(Long id) {
        LOGGER.info("Request to find trailer by id - {}", id);
        Trailer trailer = trailerRepository.findById(id)
                .orElseThrow(() -> new TrailerNotFoundException(String.format("Trailer not found for id - {}%d", id)));
        TrailerResponseModel trailerResponseModel = buildTrailerResponseModelFrom(trailer);
        LOGGER.info("Trailer successfully be find by id - {}", trailerResponseModel);
        return trailerResponseModel;
    }

    public TrailerResponseModel update(Long id, TrailerRequestModel trailerRequestModel) {
        LOGGER.info("Request to update trailer by id - {} - {}", id, trailerRequestModel);
        Trailer trailerById = trailerRepository.findById(id)
                .orElseThrow(() -> new TrailerNotFoundException(String.format("Trailer not found for id - {}%d", id)));
        trailerById.setDuration(trailerRequestModel.getDuration());
        Trailer updateTrailer = trailerRepository.save(trailerById);
        TrailerResponseModel trailerResponseModel = buildTrailerResponseModelFrom(updateTrailer);
        LOGGER.info("Trailer successfully updated by id - {}", trailerResponseModel);
        return trailerResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete trailer by id - {}", id);
        trailerRepository.deleteById(id);
        LOGGER.info("Trailer successfully deleted");
    }

    //endregion

    //region private Methods

    private Trailer buildTrailerFrom(TrailerRequestModel trailerRequestModel) {
        Trailer trailer = new Trailer();
        trailer.setDuration(trailerRequestModel.getDuration());
        return trailer;
    }

    private TrailerResponseModel buildTrailerResponseModelFrom(Trailer trailer) {
        TrailerResponseModel trailerResponseModel = new TrailerResponseModel();
        trailerResponseModel.setId(trailer.getId());
        trailerResponseModel.setDuration(trailer.getDuration());
        return trailerResponseModel;
    }

    //endregion

}
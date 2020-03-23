package com.example.demo.service.movie.soundtrack;

import com.example.demo.exception.SingerNotFoundException;
import com.example.demo.persistance.model.movie.soundtrack.singer.Singer;
import com.example.demo.persistance.repository.soundtrack.singer.SingerRepository;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerRequestModel;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SingerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SingerService.class);

    private final SingerRepository singerRepository;

    public SingerService(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    //region public Methods

    public SingerResponseModel create(SingerRequestModel singerRequestModel) {
        LOGGER.info("Request to create singer - {}", singerRequestModel);
        Singer singer = buildSingerFrom(singerRequestModel);
        Singer createSinger = singerRepository.save(singer);
        SingerResponseModel singerResponseModel = buildSingerResponseModelFrom(createSinger);
        LOGGER.info("Singer successfully created");
        return singerResponseModel;
    }

    public List<SingerResponseModel> selectAllSingers() {
        LOGGER.info("Request to select all singers");
        List<Singer> singers = singerRepository.findAll();
        List<SingerResponseModel> collect = singers.stream()
                .map(this::buildSingerResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All singers successfully selected - {}", collect);
        return collect;
    }

    public SingerResponseModel findSingerById(Long id) {
        LOGGER.info("Request to find singer by id - {}", id);
        Singer singer = singerRepository.findById(id)
                .orElseThrow(() -> new SingerNotFoundException(String.format("Singer not found for id - {}%d", id)));
        SingerResponseModel singerResponseModel = buildSingerResponseModelFrom(singer);
        LOGGER.info("Singer successfully be find - {}", singerResponseModel);
        return singerResponseModel;
    }

    public SingerResponseModel update(Long id, SingerRequestModel singerRequestModel) {
        LOGGER.info("Request to update singer by id - {} - {}", id, singerRequestModel);
        Singer singerById = singerRepository.findById(id).
                orElseThrow(() -> new SingerNotFoundException(String.format("Singer not found for id - {}%d", id)));
        singerById.setName(singerRequestModel.getName());
        singerById.setSurname(singerRequestModel.getSurname());
        Singer singerUpdate = singerRepository.save(singerById);
        SingerResponseModel singerResponseModel = buildSingerResponseModelFrom(singerUpdate);
        LOGGER.info("Singer successfully updated by id - {}", singerResponseModel);
        return singerResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete singer by id - {}", id);
        singerRepository.deleteById(id);
        LOGGER.info("Singer successfully deleted");
    }

    //endregion

    //region private Methods

    private Singer buildSingerFrom(SingerRequestModel singerRequestModel) {
        Singer singer = new Singer();
        singer.setName(singerRequestModel.getName());
        singer.setSurname(singerRequestModel.getSurname());
        return singer;
    }

    private SingerResponseModel buildSingerResponseModelFrom(Singer singer) {
        SingerResponseModel singerResponseModel = new SingerResponseModel();
        singerResponseModel.setId(singer.getId());
        singerResponseModel.setName(singer.getName());
        singerResponseModel.setSurname(singer.getSurname());
        return singerResponseModel;
    }

    //endregion

}
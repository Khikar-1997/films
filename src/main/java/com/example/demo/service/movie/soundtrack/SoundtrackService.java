package com.example.demo.service.movie.soundtrack;

import com.example.demo.exception.ComposerNotFoundException;
import com.example.demo.exception.SongNotFoundException;
import com.example.demo.exception.SoundtrackNotFoundException;
import com.example.demo.persistance.model.movie.soundtrack.composer.Composer;
import com.example.demo.persistance.model.movie.soundtrack.music.Soundtrack;
import com.example.demo.persistance.model.movie.soundtrack.song.Song;
import com.example.demo.persistance.repository.movie.soundtrack.composer.ComposerRepository;
import com.example.demo.persistance.repository.movie.soundtrack.music.SoundtrackRepository;
import com.example.demo.persistance.repository.movie.soundtrack.song.SongRepository;
import com.example.demo.rest.model.movie.soundtrack.composer.ComposerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackRequestModel;
import com.example.demo.rest.model.movie.soundtrack.music.SoundtrackResponseModel;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoundtrackService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SoundtrackService.class);

    private final SoundtrackRepository soundtrackRepository;
    private final ComposerRepository composerRepository;
    private final SongRepository songRepository;

    public SoundtrackService(SoundtrackRepository soundtrackRepository, ComposerRepository composerRepository, SongRepository songRepository) {
        this.soundtrackRepository = soundtrackRepository;
        this.composerRepository = composerRepository;
        this.songRepository = songRepository;
    }

    //region public Methods

    public SoundtrackResponseModel create(SoundtrackRequestModel soundtrackRequestModel) {
        LOGGER.info("Request to create soundtrack - {}", soundtrackRequestModel);
        Soundtrack soundtrack = buildSoundtrackFrom(soundtrackRequestModel);
        Song songById = songRepository.findById(soundtrackRequestModel.getSongId())
                .orElseThrow(() -> new SongNotFoundException(String.format("Song not found for id - {}%d", soundtrackRequestModel.getSongId())));
        Composer composerById = composerRepository.findById(soundtrackRequestModel.getComposerId())
                .orElseThrow(() -> new ComposerNotFoundException(String.format("Composer not found for id - {}%d", soundtrackRequestModel.getComposerId())));
        soundtrack.setSong(songById);
        soundtrack.setComposer(composerById);
        Soundtrack createSoundtrack = soundtrackRepository.save(soundtrack);
        SoundtrackResponseModel soundtrackResponseModel = buildSoundtrackResponseModelFrom(createSoundtrack);
        LOGGER.info("Soundtrack successfully created - {}", soundtrackResponseModel);
        return soundtrackResponseModel;
    }

    public List<SoundtrackResponseModel> selectAllSoundtracks() {
        LOGGER.info("Request to select all soundtracks");
        List<Soundtrack> soundtracks = soundtrackRepository.findAll();
        List<SoundtrackResponseModel> collect = soundtracks.stream()
                .map(this::buildSoundtrackResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All soundtracks successfully selected - {}", collect);
        return collect;
    }

    public SoundtrackResponseModel findSoundtrackById(Long id) {
        LOGGER.info("Request to find soundtrack by id - {}", id);
        Soundtrack soundtrack = soundtrackRepository.findById(id)
                .orElseThrow(() -> new SoundtrackNotFoundException(String.format("Soundtrack not found fot id - {}%d", id)));
        SoundtrackResponseModel soundtrackResponseModel = buildSoundtrackResponseModelFrom(soundtrack);
        LOGGER.info("Soundtrack successfully be find by id - {}", soundtrackResponseModel);
        return soundtrackResponseModel;
    }

    public SoundtrackResponseModel update(Long id, SoundtrackRequestModel soundtrackRequestModel) {
        LOGGER.info("Request to update soundtrack by id - {} - {}", id, soundtrackRequestModel);
        Soundtrack soundtrackById = soundtrackRepository.findById(id)
                .orElseThrow(() -> new SoundtrackNotFoundException(String.format("Soundtrack not found for id - {}%d", id)));
        Song songById = songRepository.findById(soundtrackRequestModel.getSongId())
                .orElseThrow(() -> new SongNotFoundException(String.format("Song not found for id - {}%d", soundtrackRequestModel.getSongId())));
        Composer composerById = composerRepository.findById(soundtrackRequestModel.getComposerId())
                .orElseThrow(() -> new ComposerNotFoundException(String.format("Composer not found for id - {}%d", soundtrackRequestModel.getComposerId())));
        soundtrackById.setDuration(soundtrackRequestModel.getDuration());
        soundtrackById.setSong(songById);
        soundtrackById.setComposer(composerById);
        Soundtrack updateSoundtrack = soundtrackRepository.save(soundtrackById);
        SoundtrackResponseModel soundtrackResponseModel = buildSoundtrackResponseModelFrom(updateSoundtrack);
        LOGGER.info("Soundtrack successfully updated by id - {}", soundtrackResponseModel);
        return soundtrackResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete soundtrack by id - {}", id);
        soundtrackRepository.deleteById(id);
        LOGGER.info("Soundtrack successfully deleted");
    }

    //endregion

    //region private Methods

    private Soundtrack buildSoundtrackFrom(SoundtrackRequestModel soundtrackRequestModel) {
        Soundtrack soundtrack = new Soundtrack();
        soundtrack.setDuration(soundtrackRequestModel.getDuration());
        return soundtrack;
    }

    private SoundtrackResponseModel buildSoundtrackResponseModelFrom(Soundtrack soundtrack) {
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

        ComposerResponseModel composerResponseModel = new ComposerResponseModel();
        composerResponseModel.setId(soundtrack.getComposer().getId());
        composerResponseModel.setName(soundtrack.getComposer().getName());
        composerResponseModel.setSurname(soundtrack.getComposer().getSurname());

        SoundtrackResponseModel soundtrackResponseModel = new SoundtrackResponseModel();
        soundtrackResponseModel.setId(soundtrack.getId());
        soundtrackResponseModel.setDuration(soundtrack.getDuration());
        soundtrackResponseModel.setSong(songResponseModel);
        soundtrackResponseModel.setComposer(composerResponseModel);
        return soundtrackResponseModel;
    }

    //endregion

}
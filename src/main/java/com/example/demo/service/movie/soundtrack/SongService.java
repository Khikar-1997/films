package com.example.demo.service.movie.soundtrack;

import com.example.demo.exception.SingerNotFoundException;
import com.example.demo.exception.SongNotFoundException;
import com.example.demo.persistance.model.movie.soundtrack.singer.Singer;
import com.example.demo.persistance.model.movie.soundtrack.song.Song;
import com.example.demo.persistance.repository.movie.soundtrack.singer.SingerRepository;
import com.example.demo.persistance.repository.movie.soundtrack.song.SongRepository;
import com.example.demo.rest.model.movie.soundtrack.singer.SingerResponseModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongRequestModel;
import com.example.demo.rest.model.movie.soundtrack.song.SongResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SongService.class);

    private final SongRepository songRepository;
    private final SingerRepository singerRepository;

    public SongService(SongRepository songRepository, SingerRepository singerRepository) {
        this.songRepository = songRepository;
        this.singerRepository = singerRepository;
    }

    //region public Methods

    public SongResponseModel create(SongRequestModel songRequestModel) {
        LOGGER.info("Request to create song - {}", songRequestModel);
        Song song = buildSongFrom(songRequestModel);
        Singer singer = singerRepository.findById(songRequestModel.getSingerId())
                .orElseThrow(() -> new SingerNotFoundException(String.format("Singer not found for id - {}%d", songRequestModel.getSingerId())));
        song.setSinger(singer);
        Song createSong = songRepository.save(song);
        SongResponseModel songResponseModel = buildSongResponseModelFrom(createSong);
        LOGGER.info("Song successfully created - {}", songResponseModel);
        return songResponseModel;
    }

    public List<SongResponseModel> selectAllSongs() {
        LOGGER.info("Request to select all songs");
        List<Song> songs = songRepository.findAll();
        List<SongResponseModel> collect = songs.stream()
                .map(this::buildSongResponseModelFrom)
                .collect(Collectors.toList());
        LOGGER.info("All songs successfully selected - {}", collect);
        return collect;
    }

    public SongResponseModel findSongById(Long id) {
        LOGGER.info("Request to find song by id - {}", id);
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(String.format("Song not found for id - {}%d", id)));
        SongResponseModel songResponseModel = buildSongResponseModelFrom(song);
        LOGGER.info("Song successfully be find by id - {}", songResponseModel);
        return songResponseModel;
    }

    public SongResponseModel update(Long id, SongRequestModel songRequestModel) {
        LOGGER.info("Request to update song by id - {} - {}", id, songRequestModel);
        Song songById = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(String.format("Song not found for id - {}%d", id)));
        ;
        songById.setName(songRequestModel.getName());
        songById.setDuration(songRequestModel.getDuration());
        Singer singer = singerRepository.findById(songRequestModel.getSingerId())
                .orElseThrow(() -> new SingerNotFoundException(String.format("Singer not found for id - {}%d", songRequestModel.getSingerId())));
        songById.setSinger(singer);
        Song updateSong = songRepository.save(songById);
        SongResponseModel songResponseModel = buildSongResponseModelFrom(updateSong);
        LOGGER.info("Song successfully updated by id - {}", songResponseModel);
        return songResponseModel;
    }

    public void delete(Long id) {
        LOGGER.info("Request to delete song by id - {}", id);
        songRepository.deleteById(id);
        LOGGER.info("Song successfully deleted");
    }

    //endregion

    //region private Methods

    private Song buildSongFrom(SongRequestModel songRequestModel) {
        Song song = new Song();
        song.setName(songRequestModel.getName());
        song.setDuration(songRequestModel.getDuration());
        return song;
    }

    private SongResponseModel buildSongResponseModelFrom(Song song) {
        SongResponseModel songResponseModel = new SongResponseModel();
        songResponseModel.setId(song.getId());
        songResponseModel.setName(song.getName());
        songResponseModel.setDuration(song.getDuration());
        SingerResponseModel singerResponseModel = new SingerResponseModel();
        singerResponseModel.setId(song.getSinger().getId());
        singerResponseModel.setName(song.getSinger().getName());
        singerResponseModel.setSurname(song.getSinger().getSurname());
        songResponseModel.setSinger(singerResponseModel);
        return songResponseModel;
    }

    //endregion

}
package service;

import org.springframework.stereotype.Service;
import wynk.beans.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2019 Scupids - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * @author vidisha
 */
@Service
public class SongService {

    private Map<String, Song> songTable = new HashMap<>();
    private Map<String, List<Song>> artistVsSongs = new HashMap<>();



    public void addSong(Song song) {
        if (song == null || song.getArtistIds().isEmpty()) {
            return;
        }
        String id = String.valueOf(Math.random());
        song.setId(id);
        songTable.put(id, song);
        List<String> artists = song.getArtistIds();
        for (String artist : artists) {
            List<Song> songs = artistVsSongs.get(artist);
            if (songs == null) {
                songs = new ArrayList<>();
            }
            songs.add(song);

            artistVsSongs.put(artist, songs);
        }
    }

    public List<Song> getSongs(String artistId) {
        return artistVsSongs.get(artistId);
    }

    public Song getSong(String id) {
        return songTable.get(id);
    }
}

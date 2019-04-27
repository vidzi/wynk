package service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class FollowerService {

    Map<String, List<String>> userVsFollower = new HashMap<>();
    @Autowired
    private SongService songService;
    private Map<String, List<Song>> playlistCache = new HashMap<>();


    public synchronized void follow(String userId, String artistId) {
        List<String> artistIds = userVsFollower.get(userId);
        if (artistIds == null) {
            artistIds = new ArrayList<>();
            artistIds.add(artistId);
        }

        userVsFollower.put(userId, artistIds);
        playlistCache.remove(userId);
    }

    public synchronized void unfollow(String userId, String artistId) {

        List<String> artistIds = userVsFollower.get(userId);
        if (artistIds == null) {
            return;
        }
        artistIds.remove(artistId);
        playlistCache.remove(userId);
    }

    public List<String> getArtists(String userId) {
        return userVsFollower.get(userId);
    }

    public List<Song> createPlayList(String userId) {
        if (playlistCache.get(userId) != null) {
            return playlistCache.get(userId);
        }
        List<String> artists = getArtists(userId);
        if (artists == null) {
            return new ArrayList<>();
        }

        List<Song> playlist = new ArrayList<>();
        for (String artist : artists) {
            playlist.addAll(songService.getSongs(artist));
        }

        playlistCache.put(userId, playlist);
        return playlist;
    }


}

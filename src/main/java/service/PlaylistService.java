package service;

import org.springframework.stereotype.Service;
import wynk.beans.Playlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 2019 Scupids - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * @author vidisha
 */
@Service
public class PlaylistService {
    private Map<String, Playlist> playlistTable = new HashMap<>();


    public void add(String username) {
        String id = String.valueOf(Math.random());
        playlistTable.put(id, new Playlist(id, username));
    }

    public Playlist getUser(String id) {
        return playlistTable.get(id);
    }
}

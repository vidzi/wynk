package service;

import org.springframework.stereotype.Service;
import wynk.beans.Artist;

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
public class ArtistService {

    private Map<String, Artist> artistTable = new HashMap<>();


    public void addUser(String username) {
        String id = String.valueOf(Math.random());
        artistTable.put(id, new Artist(id, username));
    }

    public Artist getUser(String id) {
        return artistTable.get(id);
    }
}

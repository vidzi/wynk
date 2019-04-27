package service;

import org.springframework.stereotype.Service;
import wynk.beans.User;

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
public class UserService {

    private Map<String, User> userTable = new HashMap<>();


    public void addUser(String username) {
        String id = String.valueOf(Math.random());
        userTable.put(id, new User(id, username));
    }

    public User getUser(String id) {
        return userTable.get(id);
    }
}

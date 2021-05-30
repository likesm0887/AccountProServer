package com.accountProServer.AccountProServer.infrastructure.repository;

import com.accountProServer.AccountProServer.domain.user.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {
    List<User> tempDB = new ArrayList<>();

    public void save(User user) {
        tempDB.add(user);
    }

    public List<User> getAll() {
        return tempDB;
    }

    public User get(String id) {
        return tempDB.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
}

package com.champ.userservice.service;

import com.champ.userservice.model.User;

import java.util.List;

public interface UserService {

    String health();

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
}

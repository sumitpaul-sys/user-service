package com.champ.userservice.service;

import com.champ.userservice.model.User;

public interface UserService {

    String health();

    User createUser(User user);
}

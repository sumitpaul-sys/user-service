package com.champ.userservice.service;

import com.champ.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    String health();
    User createUser(User user);
    Page<User> getAllUsers(Pageable page);
    User getUserById(Long id);

}

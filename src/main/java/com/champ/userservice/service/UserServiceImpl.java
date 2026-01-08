package com.champ.userservice.service;

import com.champ.userservice.model.User;
import com.champ.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String health() {
        return "UP";
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

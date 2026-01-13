package com.champ.userservice.service;

import com.champ.userservice.exception.DuplicateEmailException;
import com.champ.userservice.model.User;
import com.champ.userservice.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

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

        log.info("Creating user with email: {}", user.getEmail());

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.warn("Duplicate email detected: {}", user.getEmail());
            throw new DuplicateEmailException(user.getEmail());
        }

        return userRepository.save(user);
    }
}

package com.champ.userservice.controller;

import com.champ.userservice.dto.UserRequest;
import com.champ.userservice.dto.UserResponse;
import com.champ.userservice.model.User;
import com.champ.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/health")
    public String getHealth(){

        return "UP";
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());

        User saved = userService.createUser(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(saved.getId());
        userResponse.setName(saved.getName());
        userResponse.setEmail(saved.getEmail());

        return userResponse;
    }
}

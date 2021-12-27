package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// resources for API

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    //reference to service layer (requires constructor)
    private final UserService userService;

    //using dependency injection
    @Autowired //makes a reference be autowired and automatically injected into constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();

    }
}

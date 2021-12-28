package com.diegoquintela.verysimpleapispringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// resources for API

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {

    //reference to service layer (requires constructor)
    private final UsersService usersService;

    //using dependency injection
    @Autowired //makes a reference be autowired and automatically injected into constructor
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // deals with get requests
    @GetMapping
    public List<Users> getUsers() {
        return usersService.getUsers();

    }

    // implementing api that will take payload and store data into system
    // take the RequestBody and map it into a "Users"
    @PostMapping
    public void registerNewUsers(@RequestBody Users users) {
        usersService.addNewUsers(users);
    }


    @DeleteMapping(path = "{usersId}")
    public void deleteUsers(@PathVariable("usersId") Long usersId) {
        usersService.deleteUsers(usersId);
    }

    @PutMapping(path = {"{usersId}"})
    public void updateUsers(
            @PathVariable("usersId") Long usersId, //path variable given by usersID
            @RequestParam(required = false) String name, //request parameters, but not required
            @RequestParam(required = false) String email) {

        usersService.updateUsers(usersId, name, email); //passing down to service with updateUsers method
    }



}

package com.BabbleVerse.User;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }
}

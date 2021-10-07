package com.BabbleVerse.User;

import com.BabbleVerse.Security.UserExistsException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody User user) throws UserExistsException {
        userService.registerNewUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestBody String s) {
        return userService.getUserByName(s);
    }

    @RequestMapping("/user")
    public User user(Principal user) {
        return new User(user.getName(), null);
    }
}

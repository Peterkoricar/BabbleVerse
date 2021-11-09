package com.babbleverse.user;

import com.babbleverse.security.UserExistException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @RequestMapping("/postUser")
    public void saveUser(@RequestBody User user) throws UserExistException {
        userService.registerNewUser(user);
    }

    @GetMapping("/loginUser")
    public User getUser() {
      return userService.getCurrentUser();
    }

    @RequestMapping("/user")
    public User user(Principal user) {
        return new User(user.getName(), null);
    }
}

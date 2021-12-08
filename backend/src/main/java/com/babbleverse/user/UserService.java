package com.babbleverse.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User getUser(long id);
    boolean nameExist(User user);
    void registerNewUser(User user);
    User getCurrentUser();
    Optional<User> findUserByName(String name);
    List<User> listAll(String keyword);
}

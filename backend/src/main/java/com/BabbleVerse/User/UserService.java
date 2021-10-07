package com.BabbleVerse.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(long id);

    boolean nameExist(User user);
    void registerNewUser(User user);
    User getCurrentUser();

    User getUserByName(String s);
}

package com.BabbleVerse.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(long id);
}

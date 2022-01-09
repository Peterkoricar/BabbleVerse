package com.babbleverse.user;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    void testGetUser(){
        User user = new User("User 1", "4321");
        user.setId(1l);
        doReturn(Optional.of(user)).when(repository).findById(1l);

        Optional<User> returnedUser = service.getUser(1l);

        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user);
    }
}

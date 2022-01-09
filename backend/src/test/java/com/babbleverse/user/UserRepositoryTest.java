package com.babbleverse.user;

import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.database.rider.junit5.DBUnitExtension;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(DBUnitExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository repository;

    public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }


    @Test
    @DataSet("users.yml")
    void testFindByName(){
        Optional<User> user = repository.findByname("User 2");
        Assertions.assertTrue(user.isPresent(), "initial message 01");
        Assertions.assertEquals("User 2", user.get().getName());
        Assertions.assertEquals("2222", user.get().getPassword());
    }

    @Test
    @DataSet("users.yml")
    void testSearch(){
        List<User> users = repository.search("2");
        Assertions.assertFalse(users.isEmpty(),"initial message 02");
        Assertions.assertEquals(2, users.size());
    }
}
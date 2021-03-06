package com.babbleverse.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {
    Optional<User> findByname(String name);
    @Query("SELECT p FROM User p WHERE p.name LIKE %?1%")
    List<User> search(String keyword);
}

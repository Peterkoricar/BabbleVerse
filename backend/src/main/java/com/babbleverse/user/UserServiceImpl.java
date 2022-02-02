package com.babbleverse.user;

import com.babbleverse.security.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements com.babbleverse.user.UserService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public com.babbleverse.user.User getUser(long id) {
        return userRepository.findById(id).get();
    }



    @Override
    public boolean nameExist(User user) {
        return userRepository.findByname(user.getName()).isPresent();
    }

    @Override
    public void registerNewUser(User user) {
        if (nameExist(user)) throw new UserExistException("User with name: " + user.getName() + " already exists");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByname(name).orElseThrow();

    }
    @Override
    public Optional<User> findUserByName(String name){
        return userRepository.findByname(name);

    }
    @Override
    public List<User> listAll(String keyword) {
        if (keyword != null) {
            return userRepository.search(keyword);
        }
        return userRepository.findAll();
    }
    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}
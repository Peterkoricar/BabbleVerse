package com.babbleverse.user;

import com.babbleverse.security.UserExistException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.babbleverse.user.UserService;

@Service
public class UserServiceImpl implements com.babbleverse.user.UserService {
    private final PasswordEncoder passwordEncoder;
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
    public User getUserByName(String s) {
        return userRepository.findByname(s).orElseThrow();
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
}

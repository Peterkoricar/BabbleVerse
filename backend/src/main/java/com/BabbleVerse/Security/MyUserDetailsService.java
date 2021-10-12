package com.BabbleVerse.Security;

import com.BabbleVerse.User.User;
import com.BabbleVerse.User.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    MyUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String name) {
        Optional<User> user = userRepository.findByname(name);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(name);
        }
        return new MyUserDetails(user.get());
    }
}

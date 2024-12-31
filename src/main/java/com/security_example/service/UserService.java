package com.security_example.service;

import com.security_example.model.Users;
import com.security_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
}

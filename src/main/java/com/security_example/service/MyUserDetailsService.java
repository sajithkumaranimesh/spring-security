package com.security_example.service;

import com.security_example.model.UserPrinciple;
import com.security_example.model.Users;
import com.security_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Users byUsername = userRepository.findByUsername(username);
        System.out.println(byUsername);

        if (byUsername == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("username not found");
        }
        return new UserPrinciple(byUsername);
    }
}

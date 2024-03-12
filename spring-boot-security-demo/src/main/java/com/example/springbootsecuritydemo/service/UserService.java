package com.example.springbootsecuritydemo.service;

import com.example.springbootsecuritydemo.dao.UserRepository;
import com.example.springbootsecuritydemo.model.User;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
   private PasswordEncoder encoder;

    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByName(username);
      Optional<User> usr =  Optional.ofNullable(user);
      return usr.map(UserDtl::new).orElseThrow(()-> new UsernameNotFoundException("User not found by the name of "+username));
    }

    @Transactional
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}

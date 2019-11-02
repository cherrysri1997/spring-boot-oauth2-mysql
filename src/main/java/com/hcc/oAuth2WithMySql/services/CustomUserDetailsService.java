package com.hcc.oAuth2WithMySql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcc.oAuth2WithMySql.dao.CustomUserDetails;
import com.hcc.oAuth2WithMySql.model.User;
import com.hcc.oAuth2WithMySql.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository  userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find the user "+name);
        } else {
//        	System.out.println("Hello World");
        }
        return new CustomUserDetails(user);
    }
}
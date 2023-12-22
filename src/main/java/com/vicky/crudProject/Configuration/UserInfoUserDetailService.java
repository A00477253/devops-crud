package com.vicky.crudProject.Configuration;

import com.vicky.crudProject.Entity.User;
import com.vicky.crudProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findByUsername(username);
        return user.map(UserInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"+username));
    }
}

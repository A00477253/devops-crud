package com.vicky.crudProject.Configuration;

import com.vicky.crudProject.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserInfoUserDetails implements UserDetails {

    private String name;
    private String pwd;
    private List<GrantedAuthority> authorityList;

    public UserInfoUserDetails(User user){
        name=user.getUsername();
        pwd=user.getPassword();
        authorityList= Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

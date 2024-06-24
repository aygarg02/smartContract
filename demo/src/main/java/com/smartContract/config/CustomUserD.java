package com.smartContract.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartContract.dao.UserRepo;
import com.smartContract.model.Consumer;

public class CustomUserD implements UserDetails {

@Autowired
Consumer userRepo;



    public CustomUserD(Consumer userRepo) {
    this.userRepo = userRepo;
}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
SimpleGrantedAuthority simp=new SimpleGrantedAuthority(userRepo.getRole());
return List.of(simp);
    }

    @Override
    public String getPassword() {
      return userRepo.getPassword();
    }

    @Override
    public String getUsername() {
        return userRepo.getName();

    }
    
}

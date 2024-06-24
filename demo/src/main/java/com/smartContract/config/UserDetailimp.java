package com.smartContract.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartContract.dao.UserRepo;
import com.smartContract.model.Consumer;
@Service

public class UserDetailimp implements UserDetailsService {

@Autowired
private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


Consumer consumer= userRepo.getUserByUserName(username);
System.out.println(consumer);
if(consumer==null)  throw new UsernameNotFoundException("name does not match");
 return new CustomUserD(consumer);

    }
    
}

package com.smartContract.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartContract.model.Consumer;

@Repository
public interface UserRepo extends JpaRepository<Consumer, Integer> {
    
    @Query("select u from Consumer u where u.email = :email")
    public Consumer getUserByUserName(@Param("email") String email);

}

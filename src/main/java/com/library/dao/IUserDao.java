package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
    
}

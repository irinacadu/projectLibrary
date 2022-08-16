package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.Opinion;

@Repository
public interface IOpinionDao extends JpaRepository <Opinion, Integer> {
    
}

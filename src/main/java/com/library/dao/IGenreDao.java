package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.Genre;

@Repository
public interface IGenreDao extends JpaRepository<Genre,Integer>{
    
}

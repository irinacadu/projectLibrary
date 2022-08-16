package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.Book;

@Repository
public interface IBookDao extends JpaRepository <Book, Integer> {
    
}

package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.Prestamo;

@Repository
public interface IPrestamoDao extends JpaRepository <Prestamo,Integer> {
    
}

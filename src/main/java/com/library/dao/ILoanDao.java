package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.Loan;

@Repository
public interface ILoanDao extends JpaRepository <Loan,Integer> {
    
}

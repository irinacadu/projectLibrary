package com.library.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.library.dao.ILoanDao;

import com.library.entities.Loan;


@Service
public class LoanServiceImpl implements IServiceLoan {

    @Autowired
    private ILoanDao loanDao;

 

    @Override
    public List<Loan> getLoans() {
       
        return loanDao.findAll();
    }

    @Override
    public Loan getLoan(int idLoan) {
    
        return loanDao.findById(idLoan).get();
    }

    @Override
    public void save(Loan loan) {

       

        loanDao.save(loan);


    }

    @Override
    public void delete(int idLoan) {
        loanDao.deleteById(idLoan);
        
    }

    @Override
    public void update(int idLoan) {
       
        
    }
    
}

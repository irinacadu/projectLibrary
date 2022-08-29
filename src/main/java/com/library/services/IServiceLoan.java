package com.library.services;

import java.util.List;

import com.library.entities.Loan;

public interface IServiceLoan {
    public List<Loan>getLoans();
    public Loan getLoan(int idLoan);
    public void save (Loan  loan);
    public void delete (int idLoan);
    public void update (int idLoan);
}

package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IBookDao;
import com.library.dao.ILoanDao;
import com.library.dao.IUserDao;
import com.library.entities.Book;
import com.library.entities.Loan;
import com.library.entities.User;

@Service
public class LoanServiceImpl implements IServiceLoan {

    @Autowired
    private ILoanDao loanDao;

    @Autowired
    private IServiceBook bookService;

    @Autowired
    private IServiceUser userService;

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

        // List<User> usersList = userService.getUsers();
        // List<Book> booksList = bookService.getBooks();

        // for (User u : usersList) {

        //     u.getId();

        // }

        // userService.getUser(idUser);
        // bookService.getBook(idBook);

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

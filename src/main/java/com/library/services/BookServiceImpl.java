package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IBookDao;
import com.library.entities.Book;


@Service
public class BookServiceImpl implements IServiceBook {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> getBooks() {

        return bookDao.findAll();
    }

    @Override
    public Book getBook(int idBook) {

        return bookDao.findById(idBook).get();
    }

    @Override
    public void save(Book book) {

        bookDao.save(book);

    }

    @Override
    public void delete(int idBook) {
        bookDao.deleteById(idBook);

    }

    @Override
    public void update(int idBook) {

    }

}

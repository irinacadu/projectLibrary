package com.library.services;

import java.util.List;

import com.library.entities.Book;

public interface IServiceBook {
    public List<Book>getBooks();
    public Book getBook(int idBook);
    public void save (Book book);
    public void delete (int idBook);
    public void update (int idBook);
    public boolean reserva(int idBook);
}

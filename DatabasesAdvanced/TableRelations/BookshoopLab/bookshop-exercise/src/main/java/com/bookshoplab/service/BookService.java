package com.bookshoplab.service;

import com.bookshoplab.entities.Book;

import java.util.Date;

public interface BookService {

    void save(Book book);

    void delete(Book book);

    void delete(long id);

    Book findBook(long id);

    Iterable<Book> findBooks();

    Iterable<Book> getBooksAfter(Date date);

    Iterable<Book> getBooksFromGeorgePowellOrdered();
}

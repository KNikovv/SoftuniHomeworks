package com.bookshoplab.service;

import com.bookshoplab.entities.Book;
import com.bookshoplab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Primary
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        this.bookRepository.delete(book);
    }

    @Override
    public void delete(long id) {
        this.bookRepository.delete(id);
    }

    @Override
    public Book findBook(long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Iterable<Book> findBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Iterable<Book> getBooksAfter(Date date) {
        return this.bookRepository.findALLByReleaseDateAfter(date);
    }

    @Override
    public Iterable<Book> getBooksFromGeorgePowellOrdered() {
        return this.bookRepository.findAllBooksByGeorgePowell();
    }
}

package com.bookshoplab.service;

import com.bookshoplab.entities.Author;

import java.util.List;

public interface AuthorService {

    void save(Author author);

    void delete(Author author);

    void delete(long id);

    Author findAuthor(long id);

    Iterable<Author> findAuthors();

    List<Author> getByFirstNameEndWith(String pattern);
}

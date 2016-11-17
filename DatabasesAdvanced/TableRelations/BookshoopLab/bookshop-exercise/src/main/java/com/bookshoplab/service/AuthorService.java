package com.bookshoplab.service;

import com.bookshoplab.entities.Author;

public interface AuthorService {

    void save(Author author);

    void delete(Author author);

    void delete(long id);

    Author findAuthor(long id);

    Iterable<Author> findAuthors();

    Iterable<Author> findAuthorsWithAtleastOneBookBefore1990();

    Iterable<Author> findAllAuthorsOrderedByBookCountDesc();
}

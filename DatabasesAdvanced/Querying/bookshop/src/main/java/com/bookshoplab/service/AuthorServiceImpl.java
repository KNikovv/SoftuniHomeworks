package com.bookshoplab.service;

import com.bookshoplab.entities.Author;
import com.bookshoplab.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        this.authorRepository.delete(author);
    }

    @Override
    public void delete(long id) {
        this.authorRepository.delete(id);
    }

    @Override
    public Author findAuthor(long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Iterable<Author> findAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public List<Author> getByFirstNameEndWith(String pattern) {
        return this.authorRepository.findByFirstNameEndingWith(pattern);
    }
}

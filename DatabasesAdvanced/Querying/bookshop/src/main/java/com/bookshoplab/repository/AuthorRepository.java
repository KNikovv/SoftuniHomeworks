package com.bookshoplab.repository;

import com.bookshoplab.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findById(long id);

    Iterable<Author> findAll();

    List<Author> findByFirstNameEndingWith(String pattern);

    @Query("select a from Author a join ")
    List<Object[]> findBookCopiesByAuthor();
}

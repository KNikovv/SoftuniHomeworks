package com.bookshoplab.repository;

import com.bookshoplab.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);

    Iterable<Book> findAll();

    Iterable<Book> findALLByReleaseDateAfter(Date date);

    @Query("select b from Book b join b.author a where a.firstName = 'George' and" +
            " a.lastName = 'Powell' order by b.releaseDate desc ,b.title asc")
    Iterable<Book> findAllBooksByGeorgePowell();
}

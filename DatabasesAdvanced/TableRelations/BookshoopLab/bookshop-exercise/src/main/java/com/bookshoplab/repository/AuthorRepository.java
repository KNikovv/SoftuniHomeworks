package com.bookshoplab.repository;

import com.bookshoplab.entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findById(long id);

    Iterable<Author> findAll();

    @Query("select a from Author a join  a.books b where b.releaseDate < '1990-01-01'")
    Iterable<Author> findALlWithAtleastOneBookAfter1990();

    @Query("select  a from Author a inner join  a.books b group by a.id order by count (b.id) desc ")
    Iterable<Author> findAllBooksOrderedByBookCountDesc();

}

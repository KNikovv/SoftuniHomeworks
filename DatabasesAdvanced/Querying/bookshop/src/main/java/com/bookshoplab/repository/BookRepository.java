package com.bookshoplab.repository;

import com.bookshoplab.entities.Book;
import com.bookshoplab.entities.enums.AgeRestriction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);

    Iterable<Book> findAll();

    Iterable<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    @Query("SELECT b.title FROM Book b WHERE b.editionType = 'GOLD' AND b.copies<5000")
    List<String> findGoldenEditionBookWithLessThan5000Copies();

    @Query("SELECT b.title,b.price FROM Book b WHERE b.price<5 OR b.price>40")
    List<Object[]> findTitleAndPriceLowerThan5OrGreaterThan40();

    @Query("select b.title from Book b where year(b.releaseDate) != :year")
    List<String> findTitlesOfBooksNotInGivenYear(@Param("year") int year);

    @Query("select b.title from Book b join b.categories c where c.name in :categories")
    List<String> findTitleByCategoriesIn(@Param("categories") String... categories);

    List<Book> findByReleaseDateBefore(Date date);

    List<Book> findByTitleContains(String pattern);

    @Query("select b.title,concat(a.firstName,' ',a.lastName) from Book b join b.author a where a.lastName like :pat")
    List<Object[]> findTitleAndNameByLastNameStartWith(@Param("pat") String pattern);

    @Query("select count(b) from Book b where length(b.title) > :number ")
    int findCountOfBooksWithLongerTitle(@Param("number") int number);
}

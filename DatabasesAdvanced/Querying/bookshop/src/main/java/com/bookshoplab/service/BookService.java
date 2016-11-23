package com.bookshoplab.service;

import com.bookshoplab.entities.Book;
import com.bookshoplab.entities.enums.AgeRestriction;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookService {

    void save(Book book);

    void delete(Book book);

    void delete(long id);

    Book getBook(long id);

    Iterable<Book> getBooks();

    Iterable<Book> getByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getGoldenEditionBookWithLessThan5000Copies();

    List<Object[]> getTitleAndPriceWithinRequirements();

    List<String> getTitlesOfBooksNotInGivenYear(int year);

    List<String> getTitleByCategories(String...categories);

    List<Book> getByReleaseDateBefore(Date date);

    List<Book> getByTitleContains(String pattern);

    List<Object[]> getTitleAndNameByLastNameStartsWith(@Param("pat") String pattern);

    int getCountOfBooksWithLongerTitle(@Param("number") int number);

}

package com.bookshoplab.service;

import com.bookshoplab.entities.Book;
import com.bookshoplab.entities.enums.AgeRestriction;
import com.bookshoplab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public Book getBook(long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Iterable<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Iterable<Book> getByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> getGoldenEditionBookWithLessThan5000Copies() {
        return this.bookRepository.findGoldenEditionBookWithLessThan5000Copies();
    }

    @Override
    public List<Object[]> getTitleAndPriceWithinRequirements() {
        return this.bookRepository.findTitleAndPriceLowerThan5OrGreaterThan40();
    }

    @Override
    public List<String> getTitlesOfBooksNotInGivenYear(int year) {
        return this.bookRepository.findTitlesOfBooksNotInGivenYear(year);
    }

    @Override
    public List<String> getTitleByCategories(String... categories) {
        return this.bookRepository.findTitleByCategoriesIn(categories);
    }

    @Override
    public List<Book> getByReleaseDateBefore(Date date) {
        return this.bookRepository.findByReleaseDateBefore(date);
    }

    @Override
    public List<Book> getByTitleContains(String pattern) {
        return this.bookRepository.findByTitleContains(pattern);
    }

    @Override
    public List<Object[]> getTitleAndNameByLastNameStartsWith(String pattern) {
        pattern = pattern + "%";
        return this.bookRepository.findTitleAndNameByLastNameStartWith(pattern);
    }

    @Override
    public int getCountOfBooksWithLongerTitle(@Param("number") int number) {
        return this.bookRepository.findCountOfBooksWithLongerTitle(number);
    }
}

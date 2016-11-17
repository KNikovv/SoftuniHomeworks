package com.bookshoplab.console;

import com.bookshoplab.entities.Author;
import com.bookshoplab.entities.Book;
import com.bookshoplab.entities.Category;
import com.bookshoplab.entities.enums.AgeRestriction;
import com.bookshoplab.entities.enums.EditionType;
import com.bookshoplab.service.AuthorService;
import com.bookshoplab.service.BookService;
import com.bookshoplab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    private static Random random = new Random();

    @Override
    public void run(String... strings) throws Exception {

        //this.seedDatabase();

        //printAllTItlesAfter2000();

        //printAuthorsWIthBooksAfter1990();

        //printAuthorsOrderedByBookCount();

        //printBooksByGeorgePowell();

        List<Book> books = (List<Book>) bookService.findBooks();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

//save related books to the database
        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }

    }

    private void printBooksByGeorgePowell() {
        Iterable<Book> booksByPowell = this.bookService.getBooksFromGeorgePowellOrdered();

        for (Book book : booksByPowell) {
            System.out.printf("Title: %s,R.Date: %s, Copies: %d \n",
                    book.getTitle(),
                    book.getReleaseDate(),
                    book.getCopies());
        }
    }

    private void printAuthorsOrderedByBookCount() {
        Iterable<Author> a = this.authorService.findAllAuthorsOrderedByBookCountDesc();

        for (Author author : a) {
            System.out.printf("--%s %s | %d\n",
                    author.getFirstName(),
                    author.getLastName(),
                    author.getBooks().size());
        }
    }

    private void printAuthorsWIthBooksAfter1990() {
        Iterable<Author> a = this.authorService.findAuthorsWithAtleastOneBookBefore1990();

        for (Author author : a) {
            System.out.println(author.getFirstName());
        }
    }

    private void printAllTItlesAfter2000() {
        Date date = new GregorianCalendar(2000, 0, 0).getTime();
        Iterable<Book> books = this.bookService.getBooksAfter(date);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = this.seedAuthors();
        List<Category> categories = this.seedCategories();
        this.seedBooks(authors, categories);
    }

    private void seedBooks(List<Author> authors, List<Category> categories) throws ParseException, IOException {
        BufferedReader booksReader = new BufferedReader(new FileReader("res/books.txt"));
        String line;
        booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();
            int categoryIndex = random.nextInt(categories.size());
            Category category = categories.get(categoryIndex);

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.getCategories().add(category);
            this.bookService.save(book);
        }

    }

    private List<Category> seedCategories() throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("res/categories.txt"));
        String line;
        buffReader.readLine();
        List<Category> categories = new LinkedList<>();
        while ((line = buffReader.readLine()) != null) {
            Category category = new Category();
            category.setName(line);
            this.categoryService.save(category);
            categories.add(category);
        }

        return categories;
    }

    private List<Author> seedAuthors() throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("res/authors.txt"));
        String line;
        buffReader.readLine();
        List<Author> authors = new LinkedList<>();
        while ((line = buffReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            this.authorService.save(author);
            authors.add(author);
        }

        return authors;
    }
}

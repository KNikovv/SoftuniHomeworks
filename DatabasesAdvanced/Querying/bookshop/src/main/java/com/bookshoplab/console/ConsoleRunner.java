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
        Scanner scanner = new Scanner(System.in);

        /*
            Problem 1
        String ageRestr = scanner.nextLine().toUpperCase();
        Iterable<Book> books = bookService.getByAgeRestriction(AgeRestriction.valueOf(ageRestr));

        books.forEach(b -> System.out.println(b.getTitle()));
        */

        /*
            Problem 2
        List<String> titles = bookService.getGoldenEditionBookWithLessThan5000Copies();
        titles.forEach(System.out::println);
        */

        /*
            Problem 3
        List<Object[]> titleAndPrice = bookService.getTitleAndPriceWithinRequirements();

        titleAndPrice.forEach(o -> {
            String title = (String) o[0];
            BigDecimal price = (BigDecimal) o[1];
            System.out.printf("%s $%.2f\n", title, price);
        });
        */

        /*
            Problem 4
        int year = Integer.parseInt(scanner.nextLine());
        List<String> titles = this.bookService.getTitlesOfBooksNotInGivenYear(year);

        titles.forEach(System.out::println);
        */

        /*
            Problem 5
        String[] categories = scanner.nextLine().split("\\s+");
        List<String> titles = this.bookService.getTitleByCategories(categories);

        titles.forEach(b-> System.out.println(b));
        */

        /*
            Problem 6
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(scanner.nextLine());
        List<Book> books = this.bookService.getByReleaseDateBefore(date);

        books.forEach(b -> System.out.printf("%s %s $%.2f\n", b.getTitle(), b.getEditionType(), b.getPrice()));
        */

       /*
            Problem 7
        String pattern = scanner.nextLine();
        List<Author> authors = this.authorService.getByFirstNameEndWith(pattern);

        authors.forEach(o -> System.out.printf("%s %s\n", o.getFirstName(), o.getLastName()));
        */

        /*
            Problem 8
       String pattern = scanner.nextLine();
       List<Book> books = this.bookService.getByTitleContains(pattern);

        books.forEach(b-> System.out.println(b.getTitle()));
        */

        /*
            Problem 9
        String pattern = scanner.nextLine();
        List<Object[]> obj = this.bookService.getTitleAndNameByLastNameStartsWith(pattern);
        obj.forEach(o -> {
            String title = (String) o[0];
            String name = (String) o[1];
            System.out.printf("%s (%s)\n", title, name);
        });
        */

        /*
            Problem 10
        int number = Integer.parseInt(scanner.nextLine());
        int count = this.bookService.getCountOfBooksWithLongerTitle(number);

        System.out.printf("There are %s books with longer title than %s symbols", count, number);
        */


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

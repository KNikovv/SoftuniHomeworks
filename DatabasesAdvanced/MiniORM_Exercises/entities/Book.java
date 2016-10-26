package entities;

import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.util.Date;

@Entity(name = "books")
public class Book {

    @Id
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "published_on")
    private Date publishedOn;

    @Column(name = "language")
    private String language;

    @Column(name = "is_hard_covered")
    private Boolean isHardCovered;

    @Column(name = "rating")
    private int rating;

    public Book(String title,
                String author,
                Date publishedOn,
                String language,
                Boolean isHardCovered,
                int rating) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublishedOn(publishedOn);
        this.setLanguage(language);
        this.setHardCovered(isHardCovered);
        this.setRating(rating);
    }

    public Book() {

    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException();
        }
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getHardCovered() {
        return isHardCovered;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    private void setLanguage(String language) {
        this.language = language;
    }

    private void setHardCovered(Boolean hardCovered) {
        isHardCovered = hardCovered;
    }
}

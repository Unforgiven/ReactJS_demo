package ru.softlab.REST_demo.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private int readingYear;

    @NotNull
    private String coverImageURL;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public Book () {}

    public Book (String title, String author, int readingYear, String coverImageURL, BookType bookType) {
        this.title = title;
        this.author = author;
        this.readingYear = readingYear;
        this.coverImageURL = coverImageURL;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', autor='%s', readingYear=%d, bookType='%s']",
                id, title, author, readingYear, bookType.toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReadingYear() {
        return readingYear;
    }

    public void setReadingYear(int readingYear) {
        this.readingYear = readingYear;
    }

    public String getCoverImageURL() { return coverImageURL; }

    public void setCoverImageURL(String coverImageURL) { this.coverImageURL = coverImageURL; }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}

package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Book implements Serializable {
    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private String publisher;
    private String ISBN;    //International Standard Book Number
    private boolean activeBook;
    public Book() {
    }

    public Book(String id, String title, String author, int publicationYear,
                String publisher, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.activeBook = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isActiveBook() {
        return activeBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setActiveBook(boolean activeBook) {
        this.activeBook = activeBook;
    }

}

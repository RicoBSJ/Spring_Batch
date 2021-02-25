package com.aubrun.eric.projet7.spring_batch.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private Integer bookId;
    private String title;
    private Integer quantity;
    private String yearBook;

    public Book() {
    }

    public Book(Integer bookId, String title, Integer quantity, String yearBook) {
        this.bookId = bookId;
        this.title = title;
        this.quantity = quantity;
        this.yearBook = yearBook;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getYearBook() {
        return yearBook;
    }

    public void setYearBook(String yearBook) {
        this.yearBook = yearBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", yearBook='" + yearBook + '\'' +
                '}';
    }
}

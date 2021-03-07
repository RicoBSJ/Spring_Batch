package com.aubrun.eric.projet7.spring_batch.model;


public class Book {

    private Integer bookId;
    private String title;
    private Integer quantity;
    private String yearBook;
    private Author bookAuthor;

    public Book() {
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

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", yearBook='" + yearBook + '\'' +
                ", bookAuthor=" + bookAuthor +
                '}';
    }
}

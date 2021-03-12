package com.aubrun.eric.projet7.spring_batch.model;

public class BookDto {

    private Integer bookId;
    private String title;
    private Integer quantity;
    private String yearBook;
    private AuthorDto bookAuthor;
    private CategoryDto bookCategory;
    private EditionDto bookEdition;

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

    public AuthorDto getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(AuthorDto bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public CategoryDto getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(CategoryDto bookCategory) {
        this.bookCategory = bookCategory;
    }

    public EditionDto getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(EditionDto bookEdition) {
        this.bookEdition = bookEdition;
    }
}

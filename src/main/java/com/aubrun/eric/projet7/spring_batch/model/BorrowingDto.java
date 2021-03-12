package com.aubrun.eric.projet7.spring_batch.model;

import java.time.LocalDate;

public class BorrowingDto {

    private Integer borrowingId;
    private BookDto bookBorrowing;
    private UserAccountDto userAccountBorrowing;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Boolean renewal;

    public Integer getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Integer borrowingId) {
        this.borrowingId = borrowingId;
    }

    public BookDto getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(BookDto bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public UserAccountDto getUserAccountBorrowing() {
        return userAccountBorrowing;
    }

    public void setUserAccountBorrowing(UserAccountDto userAccountBorrowing) {
        this.userAccountBorrowing = userAccountBorrowing;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getRenewal() {
        return renewal;
    }

    public void setRenewal(Boolean renewal) {
        this.renewal = renewal;
    }
}

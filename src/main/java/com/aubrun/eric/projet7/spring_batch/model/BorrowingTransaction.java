package com.aubrun.eric.projet7.spring_batch.model;

import javax.persistence.Transient;
import java.time.LocalDate;

public class BorrowingTransaction {

    private Integer borrowingId;
    private Book bookBorrowing;
    private UserAccount userAccountBorrowing;
    private LocalDate endTransactionDate;
    @Transient
    private String strEndTransactionDate;
    private Boolean renewal;

    public BorrowingTransaction() {
    }

    public Integer getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Integer borrowingId) {
        this.borrowingId = borrowingId;
    }

    public Book getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(Book bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public UserAccount getUserAccountBorrowing() {
        return userAccountBorrowing;
    }

    public void setUserAccountBorrowing(UserAccount userAccountBorrowing) {
        this.userAccountBorrowing = userAccountBorrowing;
    }

    public LocalDate getEndTransactionDate() {
        return endTransactionDate;
    }

    public void setEndTransactionDate(LocalDate endTransactionDate) {
        this.endTransactionDate = endTransactionDate;
    }

    public String getStrEndTransactionDate() {
        return strEndTransactionDate;
    }

    public void setStrEndTransactionDate(String strEndTransactionDate) {
        this.strEndTransactionDate = strEndTransactionDate;
    }

    public Boolean getRenewal() {
        return renewal;
    }

    public void setRenewal(Boolean renewal) {
        this.renewal = renewal;
    }

    @Override
    public String toString() {
        return "BorrowingTransaction{" +
                "borrowingId=" + borrowingId +
                ", bookBorrowing=" + bookBorrowing +
                ", userAccountBorrowing=" + userAccountBorrowing +
                ", endTransactionDate=" + endTransactionDate +
                ", strEndTransactionDate='" + strEndTransactionDate + '\'' +
                ", renewal=" + renewal +
                '}';
    }
}

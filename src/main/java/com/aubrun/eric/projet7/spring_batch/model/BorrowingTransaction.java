package com.aubrun.eric.projet7.spring_batch.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BorrowingTransaction {

    @Id
    private Integer borrowingId;
    @ManyToOne
    private Book bookBorrowing;
    @ManyToOne
    private UserAccount userAccountBorrowing;
    private LocalDate endTransactionDate;
    @Transient
    private String strEndTransactionDate;
    private Boolean renewal;

    public BorrowingTransaction() {
    }

    public BorrowingTransaction(Integer borrowingId, Book bookBorrowing, UserAccount userAccountBorrowing, LocalDate endTransactionDate, String strEndTransactionDate, Boolean renewal) {
        this.borrowingId = borrowingId;
        this.bookBorrowing = bookBorrowing;
        this.userAccountBorrowing = userAccountBorrowing;
        this.endTransactionDate = endTransactionDate;
        this.strEndTransactionDate = strEndTransactionDate;
        this.renewal = renewal;
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

package com.aubrun.eric.projet7.spring_batch.dao;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.Date;

public class BorrowingTransaction {

    @Id
    private Integer borrowingId;
    private Book bookBorrowing;
    private UserAccount userAccountBorrowing;
    private Date beginTransactionDate;
    @Transient
    private String strBeginTransactionDate;
    private Date endTransactionDate;
    @Transient
    private String strEndTransactionDate;
    private Boolean renewal;

    public BorrowingTransaction() {
    }

    public BorrowingTransaction(Integer borrowingId, Book bookBorrowing, UserAccount userAccountBorrowing, Date beginTransactionDate, String strBeginTransactionDate, Date endTransactionDate, String strEndTransactionDate, Boolean renewal) {
        this.borrowingId = borrowingId;
        this.bookBorrowing = bookBorrowing;
        this.userAccountBorrowing = userAccountBorrowing;
        this.beginTransactionDate = beginTransactionDate;
        this.strBeginTransactionDate = strBeginTransactionDate;
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

    public Date getBeginTransactionDate() {
        return beginTransactionDate;
    }

    public void setBeginTransactionDate(Date beginTransactionDate) {
        this.beginTransactionDate = beginTransactionDate;
    }

    public String getStrBeginTransactionDate() {
        return strBeginTransactionDate;
    }

    public void setStrBeginTransactionDate(String strBeginTransactionDate) {
        this.strBeginTransactionDate = strBeginTransactionDate;
    }

    public Date getEndTransactionDate() {
        return endTransactionDate;
    }

    public void setEndTransactionDate(Date endTransactionDate) {
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
                ", beginTransactionDate=" + beginTransactionDate +
                ", strBeginTransactionDate='" + strBeginTransactionDate + '\'' +
                ", endTransactionDate=" + endTransactionDate +
                ", strEndTransactionDate='" + strEndTransactionDate + '\'' +
                ", renewal=" + renewal +
                '}';
    }
}

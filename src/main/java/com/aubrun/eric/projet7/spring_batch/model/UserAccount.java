package com.aubrun.eric.projet7.spring_batch.model;

import java.util.List;

public class UserAccount {

    private Integer userId;
    private String username;
    private String email;
    private List<BorrowingTransaction> borrowingList;

    public UserAccount() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BorrowingTransaction> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<BorrowingTransaction> borrowingList) {
        this.borrowingList = borrowingList;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", borrowingList=" + borrowingList +
                '}';
    }
}

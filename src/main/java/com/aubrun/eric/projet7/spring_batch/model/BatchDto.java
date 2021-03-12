package com.aubrun.eric.projet7.spring_batch.model;

import java.util.List;

public class BatchDto {

    private String username;
    private String email;
    private List<BorrowingDto> borrowings;

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

    public List<BorrowingDto> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<BorrowingDto> borrowings) {
        this.borrowings = borrowings;
    }
}

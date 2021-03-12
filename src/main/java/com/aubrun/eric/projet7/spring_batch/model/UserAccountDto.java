package com.aubrun.eric.projet7.spring_batch.model;

import java.util.List;
import java.util.Set;

public class UserAccountDto {

    private Integer userId;
    private String username;
    private String email;
    private String password;
    private List<BorrowingDto> borrowingDtoList;
    private Set<RoleDto> roleDtos;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BorrowingDto> getBorrowingDtoList() {
        return borrowingDtoList;
    }

    public void setBorrowingDtoList(List<BorrowingDto> borrowingDtoList) {
        this.borrowingDtoList = borrowingDtoList;
    }

    public Set<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(Set<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }
}

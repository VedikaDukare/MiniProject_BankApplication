package com.techlabs.model;

public class User {

    private int userId;
    private String userName;
    private String userPassword; // Consider using a more secure approach to handle passwords
    private String userType;

    // Default constructor
    public User() {}

    public User(int userId, String userName, String userPassword, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userType=" + userType + "]";
    }
}

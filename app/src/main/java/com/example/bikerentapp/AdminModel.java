package com.example.bikerentapp;

public class AdminModel {
    String UserName;
    String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public AdminModel()
    {

    }
    public AdminModel(String userName, String password) {
        UserName = userName;
        Password = password;
    }
}

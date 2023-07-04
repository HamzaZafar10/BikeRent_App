package com.example.bikerentapp;

public class EmailModel {
    private String Email;
    private String Password;

    public EmailModel()
    {

    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public EmailModel(String email, String password) {
        Email = email;
        Password = password;
    }
}

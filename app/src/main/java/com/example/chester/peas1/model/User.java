package com.example.chester.peas1.model;

/**
 * Created by andreyv on 2018-02-24.
 */

public class User {
    private String email = "";
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }


}

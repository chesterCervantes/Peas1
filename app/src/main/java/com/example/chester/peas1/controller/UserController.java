package com.example.chester.peas1.controller;

import com.example.chester.peas1.model.User;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by andreyv on 2018-02-24.
 */

public class UserController {

    public ArrayList<User> userList = new ArrayList<>();

    public UserController() {
        fetchUserList();
    }

    public void fetchUserList(){
        // fetch from db - for loop
        String email = "";
        String password = "";
        String firstName = "";
        String lastName = "";

        User user = new User(email, password, firstName, lastName);

        this.userList.add(user);
    }

    public User getUserByEmail(String email){
        for(int i = 0; i < this.userList.size(); i++){
            if(String.equals(this.userList.get(i).getEmail(), email)){
                return this.userList.get(i);
            }
        }
    }
}

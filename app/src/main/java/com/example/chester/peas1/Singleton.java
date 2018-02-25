package com.example.chester.peas1;

import com.example.chester.peas1.controller.TripController;
import com.example.chester.peas1.controller.UserController;
import com.example.chester.peas1.model.Trip;
import com.example.chester.peas1.model.User;

/**
 * Created by andreyv on 2018-02-25.
 */

public class Singleton {
    private UserController userController;
    private TripController tripController;

    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        userController = new UserController();
        tripController = new TripController(userController);
    }

    public UserController getUserController(){
        return userController;
    }

    public TripController getTripController(){
        return tripController;
    }


}

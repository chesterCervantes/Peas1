package com.example.chester.peas1.controller;

import com.example.chester.peas1.model.Trip;
import com.example.chester.peas1.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreyv on 2018-02-24.
 */

public class TripController {

    public ArrayList<Trip> tripList = new ArrayList<>();
    private UserController userController;

    public TripController(UserController userController) {
        fetchTripTable();
        this.userController = userController;
    }

    public void fetchTripTable() {

        // probably for loop
        // extract a trip
        int startTime = 0;
        int arrivalTime = 0;
        String userEmail = "";
        String origin = "Burnaby";
        String destination = "Surrey";

        User driver = userController.getUserByEmail(userEmail);

        Trip trip = new Trip(startTime, arrivalTime, driver, origin, destination);
        tripList.add(trip);
    }

    public void addTrip(int startTime, int arrivalTime, User driver, String origin, String destination){
        Trip trip = new Trip(startTime, arrivalTime, driver, origin, destination);
        tripList.add(trip);
    }

    public void pushTripTable() {
        // push trip table to firebase
    }

}

package com.example.chester.peas1.controller;

import android.util.Log;

import com.example.chester.peas1.model.Trip;
import com.example.chester.peas1.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by andreyv on 2018-02-24.
 */

public class TripController {

    public ArrayList<Trip> tripList = new ArrayList<>();
    private UserController userController;
    private DatabaseReference tripRef;

    public TripController(UserController userController, DatabaseReference tripRef) {
        //fetchTripTable();
        this.userController = userController;
        this.tripRef = tripRef;

        // Read from the database
        tripRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                fetchTripTable(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    public void fetchTripTable(DataSnapshot dataSnapshot) {


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

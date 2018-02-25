package com.example.chester.peas1.controller;

import android.util.Log;
import android.widget.Toast;

import com.example.chester.peas1.model.Trip;
import com.example.chester.peas1.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Peas");
    ///DatabaseReference usersRef = myRef.child("users");
    private DatabaseReference postsRef = myRef.child("Trips");

    public TripController(UserController userController) {
        //fetchTripTable();
        this.userController = userController;

        // Read from the database
        this.postsRef.addValueEventListener(new ValueEventListener() {
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

        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Trip trip = ds.getValue(Trip.class);
            trip.resolveUsers(userController);
            tripList.add(trip);
        }

        // probably for loop
        // extract a trip
        /*int startTime = 0;
        int arrivalTime = 0;
        String userEmail = "";
        String origin = "Burnaby";
        String destination = "Surrey";*/



        /*Trip trip = new Trip(startTime, arrivalTime, driver, origin, destination);
        tripList.add(trip);*/
    }

    public void addTrip(int startTime, int arrivalTime, int passengerNum, String origin, String destination, String driverEmail, String passenger1Email, String passenger2Email, String passenger3Email){
        Trip trip = new Trip(startTime, arrivalTime, passengerNum, origin, destination, driverEmail, passenger1Email, passenger2Email, passenger3Email);
        tripList.add(trip);
    }

    public void pushTripTable() {
        // push trip table to firebase
    }

}

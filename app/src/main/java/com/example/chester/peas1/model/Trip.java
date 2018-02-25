package com.example.chester.peas1.model;

import java.util.ArrayList;

/**
 * Created by andreyv on 2018-02-24.
 */

public class Trip {

    private int startTime = 0;// unix time
    private int arrivalTime = 0; //unix time
    public User driver; //user with driver permissions to host the ride
    public ArrayList<User> passengers = new ArrayList<>();
    private int passengerNum = 0; //num of users

    private String origin = "";
    private String destination = "";

    public Trip(int startTime, int arrivalTime, User driver, String origin, String destination){
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.driver = driver;
    }

    public int getStartTime(){
        return startTime;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public int getPassengerNum(){
        return passengerNum;
    }

    public void addPassenger(User passenger){
        this.passengers.add(passenger);
    }

}
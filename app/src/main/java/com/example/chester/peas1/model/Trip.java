package com.example.chester.peas1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreyv on 2018-02-24.
 */

public class Trip {

    private int startTime = 0;// unix time
    private int arrivalTime = 0; //unix time
    private User driver = new User(); //user with driver permissions to host the ride
    private List passengers =  new ArrayList(); //list of users who will be sharing the ride

    private String origin = "";
    private String destination = "";

    public Trip(int startTime, int arrivalTime, User driver, String origin, String destination){
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.driver = driver;
    }

    public void addPassenger(User passenger){
        this.passengers.add(passenger);
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



}

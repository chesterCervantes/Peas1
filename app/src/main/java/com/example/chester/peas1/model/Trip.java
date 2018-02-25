package com.example.chester.peas1.model;

import com.example.chester.peas1.controller.UserController;

import java.util.ArrayList;

/**
 * Created by andreyv on 2018-02-24.
 */

public class Trip {


    public int startTime;// unix time
    public int arrivalTime; //unix time
    public int passengerNum; //num of users
    public String driverEmail;
    public String passenger1Email;
    public String passenger2Email;
    public String passenger3Email;
    public String origin;
    public String destination;
    public String key;

    public User driver; //user with driver permissions to host the ride

    public ArrayList<User> passengers = new ArrayList<>();

    public Trip(int startTime, int arrivalTime, int passengerNum, String driverEmail, String passenger1Email, String passenger2Email, String passenger3Email, String origin, String destination) {
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;

        this.passengerNum = passengerNum;
        this.driverEmail = driverEmail;
        this.passenger1Email = passenger1Email;
        this.passenger2Email = passenger2Email;
        this.passenger3Email = passenger3Email;
        this.origin = origin;
        this.destination = destination;
    

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


    public void resolveUsers(UserController userController){
        this.driver = userController.getUserByEmail(driverEmail);
        this.passengers.add(userController.getUserByEmail(passenger1Email));
        this.passengers.add(userController.getUserByEmail(passenger2Email));
        this.passengers.add(userController.getUserByEmail(passenger3Email));
    }


}

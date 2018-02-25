package com.example.chester.peas1.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreyv on 2018-02-24.
 */

public class TripController {

    private List tripList;

    public TripController() {
        this.tripList = fetchTripTable();
    }

    private List fetchTripTable() {
        // extract trip
        List tripList = new ArrayList();

        // probably for loop
        tripList.add(trip);

        return tripList;
    }

    public void updateTripTable(){
        this.tripList = fetchTripTable();
    }

    public List getTripList() {
        return this.tripList;
    }

}

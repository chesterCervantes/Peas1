package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.chester.peas1.controller.TripController;
import com.example.chester.peas1.controller.UserController;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TripInfoAct extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Peas");
    ///DatabaseReference usersRef = myRef.child("users");
    private DatabaseReference postsRef = myRef.child("Trips");

    //private Singleton singleton = Singleton.getInstance();
    //private TripController tripController = singleton.getTripController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_info);
        addTripButton();
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, TripInfoAct.class);
    }

    private void addTripButton() {
        Button btn = (Button) findViewById(R.id.btn_AddTrip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit = (EditText) findViewById(R.id.txt_meeting);
                String location = edit.getText().toString();
                edit = (EditText) findViewById(R.id.txt_departureTime);
                String depTime = edit.getText().toString();
                edit = (EditText) findViewById(R.id.txt_PlannedArival);
                String arrTime = edit.getText().toString();

                /*int startTime = 1;
                int arrivalTime = 2;
                int passengerNum = 0;
                String origin = "Burnaby";
                String destination = "Surrey";
                St*/

                DatabaseReference newpostsRef = postsRef.push();
                newpostsRef.child("startTime").setValue(1);
                newpostsRef.child("arrivalTime").setValue(2);
                newpostsRef.child("passengerNum").setValue(0);
                newpostsRef.child("origin").setValue("Burnaby");
                newpostsRef.child("destination").setValue("Surrey");
                newpostsRef.child("driverEmail").setValue("a@b.c");
                newpostsRef.child("passenger1Email").setValue("a1@b.c");
                newpostsRef.child("passenger2Email").setValue("a2@b.c");
                newpostsRef.child("passenger3Email").setValue("a3@b.c");

                //tripController.addTrip(startTime, arrivalTime, passengerNum, origin, destination, driverEmail, passenger1Email, passenger2Email, passenger3Email);
            }
        });
    }
}

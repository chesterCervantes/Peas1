package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TripInfoAct extends AppCompatActivity {

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
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Peas");
                ///DatabaseReference usersRef = myRef.child("users");
                DatabaseReference postsRef = myRef.child("Trips");
                DatabaseReference newpostsRef = postsRef.push();
                newpostsRef.child("StartLocation").setValue(location);
                newpostsRef.child("StartTime").setValue(1);
                newpostsRef.child("ArrivalTime").setValue("2");
                newpostsRef.child("Location").setValue("Burnaby");


            }
        });
    }
}

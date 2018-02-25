package com.example.chester.peas1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeAct extends AppCompatActivity {
    public static final int REQUEST_CODE_GET_ARRIVAL_TIME = 10;

    private int hours = 0;
    private int min = 0;

    private String course = "No specific";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addTripButton();
        addTimeButton();
        addProfileButton();

    }

    private void addProfileButton() {
        Button btn = (Button) findViewById(R.id.btn_YourTrips);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ProfileAct.makeIntent(HomeAct.this);
                startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HomeAct.class);
    }

    private void addTripButton() {
        Button btn = (Button) findViewById(R.id.btn_CreateTrip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = TripInfoAct.makeIntent(HomeAct.this);
                startActivity(intent);
            }
        });
    }

    private void addTimeButton() {
        Button btn = (Button) findViewById(R.id.btn_Filter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = SelectTime.makeIntent(HomeAct.this);
                startActivityForResult(intent, REQUEST_CODE_GET_ARRIVAL_TIME);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_GET_ARRIVAL_TIME:
                if (resultCode == Activity.RESULT_OK) {

                    hours = data.getIntExtra("timeHours", 0);
                    min = data.getIntExtra("timeMin", 0);

                    if (!course.equals("") && course != null ) {
                        course = data.getStringExtra("course");
                    }
                }
                Toast.makeText(HomeAct.this, "test " + hours + " " + min, Toast.LENGTH_LONG).show();

        }

    }
}

package com.example.chester.peas1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chester.peas1.controller.TripController;
import com.example.chester.peas1.controller.UserController;
import com.example.chester.peas1.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class HomeAct extends AppCompatActivity {
    public static final int REQUEST_CODE_GET_ARRIVAL_TIME = 10;
    private int hours;
    private int min;

    private Singleton singleton = Singleton.getInstance();
    private TripController tripController = singleton.getTripController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addTripButton();
        addTimeButton();

        populateListView();

    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HomeAct.class);
    }

    private void populateListView() {
        List<Trip> tripList = tripController.tripList;
        List<String> listStr = new ArrayList<>();
        listStr.add("w");
        listStr.add("123434");

        String str = "";
        for (Trip tr : tripList) {
            str = tr.driverEmail;
            listStr.add(str);
        }

        String[] arrStr = listStr.toArray(new String[listStr.size()]);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listviewhome, R.id.textview2, arrStr);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);




    }

    private void addTripButton() {
        Button btn = (Button) findViewById(R.id.btn_CreateTrip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =TripInfoAct.makeIntent(HomeAct.this);
                startActivity(intent);
            }
        });
    }

    private void addTimeButton() {
        Button btn = (Button) findViewById(R.id.btn_TimeSelect);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =SelectTime.makeIntent(HomeAct.this);
                startActivityForResult(intent,REQUEST_CODE_GET_ARRIVAL_TIME);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode){
        case REQUEST_CODE_GET_ARRIVAL_TIME:
        if (resultCode== Activity.RESULT_OK){
            hours=data.getIntExtra("timeHours",0);
            min=data.getIntExtra("timeMin",0);

        }
            Toast.makeText(HomeAct.this ,"test "+hours+" "+min,Toast.LENGTH_LONG).show();

    }



    }
}

package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addTripButton();

    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, HomeAct.class);
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


}

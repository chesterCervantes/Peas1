package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class SelectTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        addActivity();
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, SelectTime.class);
    }

    private void addActivity (){
        Button button = (Button ) findViewById(R.id.btn_AcceptTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker simpleTimePicker=(TimePicker)findViewById(R.id.timePicker);
                int hours =simpleTimePicker.getHour();
                int min =simpleTimePicker.getMinute();

                Intent intent = new Intent();
                intent.putExtra("timeHours" , hours);
                intent.putExtra("timeMin" , min);
                setResult(HomeAct.RESULT_OK,intent);
                finish();

            }

        });
    }



}

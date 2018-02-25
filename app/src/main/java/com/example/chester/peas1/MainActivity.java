package com.example.chester.peas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///myRef.setValue("Hello, Chester123 :)!");
        SetupStartButton();


    }
    // Test
    //FOr test branch
    // For test Branch 2

    private void SetupStartButton() {
        Button btn = (Button) findViewById(R.id.button_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Main2Activity.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

}

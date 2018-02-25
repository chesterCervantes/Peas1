package com.example.chester.peas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.amazonaws.mobile.client.AWSMobileClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AWSMobileClient.getInstance().initialize(this).execute();
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

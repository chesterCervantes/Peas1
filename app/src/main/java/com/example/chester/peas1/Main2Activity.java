package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
// TEst
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SetupSignUpButton();
        SetupSignInButton();



    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Main2Activity.class);
    }

    private void SetupSignUpButton() {
        Button btn = (Button) findViewById(R.id.signUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =signUp.makeIntent(Main2Activity.this);
                startActivity(intent);
            }
        });
    }

    private void SetupSignInButton() {
        Button btn = (Button) findViewById(R.id.logIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =SignInAct.makeIntent(Main2Activity.this);
                startActivity(intent);
            }
        });
    }


}

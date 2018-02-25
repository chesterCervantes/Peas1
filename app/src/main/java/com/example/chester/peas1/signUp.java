package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SetupSignInButton();

    }



    public static Intent makeIntent(Context context) {
        return new Intent(context, signUp.class);
    }

    private void SetupSignInButton() {
        Button btn = (Button) findViewById(R.id.btn_SignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =SignInAct.makeIntent(signUp.this);
                startActivity(intent);
            }
        });
    }
}

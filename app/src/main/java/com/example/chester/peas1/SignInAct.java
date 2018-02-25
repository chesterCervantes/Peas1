package com.example.chester.peas1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        SetupSignInButton();

    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, SignInAct.class);
    }

    private void SetupSignInButton() {
        Button btn = (Button) findViewById(R.id.btn_signIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =HomeAct.makeIntent(SignInAct.this);
                startActivity(intent);
            }
        });
    }
}

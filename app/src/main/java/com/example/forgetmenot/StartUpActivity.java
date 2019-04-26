package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartUpActivity extends AppCompatActivity {
    private Button button;      //button variables
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        button = (Button) findViewById(R.id.start_log);
        button.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Button to open the Login Page
            public void onClick(View v) {
                openLog();
            }
        });
                                                                //matching button variables with XML IDs
        button2 = (Button) findViewById(R.id.start_reg);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override                                                  //Button to open the Register Page
            public void onClick(View v) {
                openReg();
            }
        });

    }

    public void openLog() {
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);                                                  //the script called to open the login and register page
    }

    public void openReg() {
        Intent intent2 = new Intent (this, RegisterActivity.class);
        startActivity(intent2);
    }
}


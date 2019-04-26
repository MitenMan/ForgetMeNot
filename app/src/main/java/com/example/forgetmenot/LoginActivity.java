package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    EditText mTextUsername;
    EditText mTextPassword;     //new variables
    Button mButtonLogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.email_login);
        mTextPassword = (EditText) findViewById(R.id.pass_login);       //attaching variables to XML IDs
        mButtonLogin = (Button) findViewById(R.id.button_log_log);

        button = (Button) findViewById(R.id.button_log_reg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain();
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();     //check for correct username and pwd
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Toast.makeText(LoginActivity.this, "Login Successful!",Toast.LENGTH_SHORT).show();//success message
                    Intent moveToLogin = new Intent(LoginActivity.this, MainActivity.class);         //navigates the user to the hoome page on successfull login
                    startActivity(moveToLogin); //successful login navigates to Home page
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "The Username and Password does not match",Toast.LENGTH_SHORT).show();        //failure message
                }
            }
        });

    }

    public void openMain() {
        Intent intent = new Intent(this, RegisterActivity.class); //function to navigate to the register page
        startActivity(intent);
    }
}

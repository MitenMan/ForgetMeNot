package com.example.forgetmenot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button button;
    EditText rTextUsername;                  //setting variable names
    EditText rTextPassword;
    EditText rConfirmPassword;
    Button rButtonReg;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        rTextUsername = (EditText) findViewById(R.id.email_reg);
        rTextPassword = (EditText) findViewById(R.id.pass_reg);
        rConfirmPassword = (EditText) findViewById(R.id.cnfpass_reg);        //matching variables with XML IDs
        rButtonReg = (Button) findViewById(R.id.button_reg_reg);


        button = (Button) findViewById(R.id.button_reg_log);
        button.setOnClickListener(new View.OnClickListener() {              //onClickListener to go to the login page
            @Override
            public void onClick(View v) {
                openLog();
            }
        });

        rButtonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = rTextUsername.getText().toString().trim();
                String pwd = rTextPassword.getText().toString().trim();     //converting EditText value to string
                String cpwd = rConfirmPassword.getText().toString().trim();

                if(pwd.equals(cpwd)){
                    long val = db.addUser(user, pwd);   //adding user credentials to the database
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this, "Registration successful!",Toast.LENGTH_SHORT).show(); //success message
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class); //navigating the user to the login page after a successful login
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration error",Toast.LENGTH_SHORT).show(); //registration error message
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this, "Passwords do not match",Toast.LENGTH_SHORT).show(); //error message if password do not match
                }
            }
        });

    }

    public void openLog() {
        Intent intent = new Intent(this, LoginActivity.class);  //function to navigate to the login page
        startActivity(intent);
    }

}

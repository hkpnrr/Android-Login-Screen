package com.example.sharedpreferencesloginekrandeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText textInputUsername,textInputPassword;
    private Button buttonSignin;
    private TextView textViewSignUp;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputUsername = findViewById(R.id.textInputUsername);
        textInputPassword = findViewById(R.id.textInputPassword);
        buttonSignin = findViewById(R.id.buttonSignin);
        textViewSignUp = findViewById(R.id.textViewSignup);

        sp =getSharedPreferences("info",MODE_PRIVATE);
        editor =sp.edit();



        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = textInputUsername.getText().toString();
                password = textInputPassword.getText().toString();

                if(sp.getString(username,"").equals(password)){
                    Toast.makeText(MainActivity.this,"WELCOME USER : "+username,Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"WRONG PASSWORD",Toast.LENGTH_LONG).show();
                }


            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
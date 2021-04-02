package com.example.sharedpreferencesloginekrandeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {
    private TextInputEditText textInputNewusername,textInputNewpassword;
    private Button buttonSignup;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String newUsername;
    private String newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textInputNewusername = findViewById(R.id.textInputNewusername);
        textInputNewpassword = findViewById(R.id.textInputNewpassword);
        buttonSignup = findViewById(R.id.buttonSignup);

        sp = getSharedPreferences("info",MODE_PRIVATE);
        editor = sp.edit();

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newUsername = textInputNewusername.getText().toString();
                newPassword = textInputNewpassword.getText().toString();

                editor.putString(newUsername,newPassword);
                editor.commit();


            }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
    }
}
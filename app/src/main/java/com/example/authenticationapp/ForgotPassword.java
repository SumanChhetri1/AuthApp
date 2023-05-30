package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void Signup(View view) {
        Intent intent_Signup=new Intent(ForgotPassword.this,Signup.class);
        startActivity(intent_Signup);
        Toast.makeText(ForgotPassword.this,"Signup comp",Toast.LENGTH_SHORT).show();
    }

    public void Login(View view) {
        Intent intent_Login=new Intent(ForgotPassword.this,Login.class);
        startActivity(intent_Login);
        Toast.makeText(ForgotPassword.this,"Login comp",Toast.LENGTH_SHORT).show();
    }
}
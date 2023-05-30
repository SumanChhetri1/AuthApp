package com.example.authenticationapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=findViewById(R.id.pic);
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(30000);
                    Intent intent=new Intent(getApplicationContext(),Signup.class);
                    startActivity(intent);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
package com.example.authenticationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText txt_email,txt_password;
    Button login_btn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth= FirebaseAuth.getInstance();
        
        init();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txt_email.getText().toString().trim();
                String password=txt_password.getText().toString();
                if(email.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                if(password.equals(password)){
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent loginIntent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(loginIntent);
                                Toast.makeText(Login.this, "login copt", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(Login.this, "Login failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void init(){
        txt_email=findViewById(R.id.et_email);
        txt_password=findViewById(R.id.et_pass);
        login_btn=findViewById(R.id.btn_login);
    }

    public void ForgotPassword(View view) {
        Intent intent_ForgotPassword=new Intent(Login.this,ForgotPassword.class);
        startActivity(intent_ForgotPassword);
        Toast.makeText(Login.this,"Forgot Password comp",Toast.LENGTH_SHORT).show();
    }

    public void Signup(View view) {
        Intent intent_Signup=new Intent(Login.this,Signup.class);
        startActivity(intent_Signup);
        Toast.makeText(Login.this,"Signup comp",Toast.LENGTH_SHORT).show();
    }
}
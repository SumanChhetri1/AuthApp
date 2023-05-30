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

public class Signup extends AppCompatActivity {
EditText txt_username,txt_email,txt_password,txt_cpassword;
Button signup_btn;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth= FirebaseAuth.getInstance();

        init();
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txt_email.getText().toString().trim();
                String usename=txt_username.getText().toString().trim();
                String password=txt_password.getText().toString().trim();
                String cpassword=txt_cpassword.getText().toString().trim();

                if(email.isEmpty()){
                    Toast.makeText(Signup.this,"please enter email",Toast.LENGTH_SHORT).show();
                }
                if(usename.isEmpty()){
                    Toast.makeText(Signup.this,"please enter usename",Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty()){
                    Toast.makeText(Signup.this,"please enter password",Toast.LENGTH_SHORT).show();
                }
                if(cpassword.isEmpty()){
                    Toast.makeText(Signup.this,"please enter confirm password",Toast.LENGTH_SHORT).show();
                }
                if(password.length()>6){
                    Toast.makeText(Signup.this, "password too short", Toast.LENGTH_SHORT).show();
                }
                if(password.equals(cpassword)){
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent signupIntent= new Intent(getApplicationContext(),Login.class);
                                startActivity(signupIntent);
                                Toast.makeText(Signup.this, "Signup copt", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }
                    });
                }

            }
        });
    }
    public void init(){
        txt_username=findViewById(R.id.et_username);
        txt_email=findViewById(R.id.et_email);
        txt_password=findViewById(R.id.et_pass);
        txt_cpassword=findViewById(R.id.et_cpass);
        signup_btn=findViewById(R.id.btn_signup);
    }

    public void Login(View view) {
        Intent intent_Login=new Intent(Signup.this,Login.class);
        startActivity(intent_Login);
        Toast.makeText(Signup.this,"Login comp",Toast.LENGTH_SHORT).show();
    }
}
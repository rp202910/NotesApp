package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView txt = findViewById(R.id.signup);

        firebaseAuth=FirebaseAuth.getInstance();








        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              EditText edt=findViewById(R.id.msignup);
                EditText pdt=findViewById(R.id.pass);
              String mail=edt.getText().toString().trim();
              String password=pdt.getText().toString().trim();

              if(mail.isEmpty() || password.isEmpty()){

                  Toast.makeText(getApplicationContext(), "ALL feilds are important", Toast.LENGTH_SHORT).show();

              }
              else{
                    firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                                sendEmailVerification();
                            }
                            else{

                                Toast.makeText(getApplicationContext(),"Not successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



              }


            }
        });



    }
    private void sendEmailVerification(){

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),"Verfication link sent, verify it",Toast.LENGTH_SHORT).show();

                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(SignUp.this,MainActivity.class));
                }
            });


        }
        else{
            Toast.makeText(getApplicationContext(),"Fail to send mail",Toast.LENGTH_SHORT).show();


        }



    }









}
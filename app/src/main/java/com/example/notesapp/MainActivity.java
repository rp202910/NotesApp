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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        TextView txt = findViewById(R.id.signup);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(getApplicationContext(),SignUp.class);
                startActivity(in);
            }
        });



        TextView txt1 = findViewById(R.id.forgot);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(getApplicationContext(),forgotPassword.class);
                startActivity(in);
            }
        });

        TextView txt2=findViewById(R.id.login_mail);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt=findViewById(R.id.loginemail);
                EditText pdt=findViewById(R.id.loginpassword);
                String mail=edt.getText().toString().trim();
                String password=pdt.getText().toString().trim();

                if(mail.isEmpty() || password.isEmpty()){

                    Toast.makeText(getApplicationContext(), "ALL feilds are important", Toast.LENGTH_SHORT).show();

                }
                else{
                   firebaseAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                checkEmail();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Account not exist", Toast.LENGTH_SHORT).show();

                            }

                       }
                   });


                }

            }
        });



    }
    private void checkEmail(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser.isEmailVerified()==true){

            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();

            finish();
            startActivity(new Intent(getApplicationContext(),notesActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(), "Your Email is not verified yet!!!!", Toast.LENGTH_SHORT).show();


        }




    }
}
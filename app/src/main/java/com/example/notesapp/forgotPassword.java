package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {
    private EditText mforgotpassword;
    private Button mpasswordrecover;
    private TextView mgotologin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        mforgotpassword=findViewById(R.id.forgotpassword);
        mpasswordrecover=findViewById(R.id.passwordrecover);
        mgotologin=findViewById(R.id.gotologin);
        firebaseAuth=FirebaseAuth.getInstance();


        mgotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        mpasswordrecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=mforgotpassword.getText().toString().trim();
                if(mail.isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter your mail",Toast.LENGTH_SHORT).show();
                else{
                    //we have to send mail.
                    firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Mail Sent You can recover",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(forgotPassword.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Mail Snot registered",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });


    }
}
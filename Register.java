package com.example.healthpoint;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity{

    EditText FullName, Matric, EMAIL, PASSWORD,PHONE;
    Button RegisterBtn;
    TextView LoginPg;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullName = findViewById(R.id.fullName);
        Matric = findViewById(R.id.Matric);
        EMAIL = findViewById(R.id.email);
        PASSWORD = findViewById(R.id.password);
        PHONE = findViewById(R.id.Phone);
        RegisterBtn = findViewById(R.id.register);
        LoginPg = findViewById(R.id.Create);

        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.loading);

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = EMAIL.getText().toString().trim();
                String passw = PASSWORD.getText().toString().trim();

                if (TextUtils.isEmpty(Email)) {
                    EMAIL.setError("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(passw)) {
                    PASSWORD.setError("Password is required!");
                    return;
                }


                if (passw.length() < 6 ){
                    PASSWORD.setError("Password must be >= 6 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(Email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this,"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        LoginPg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondFragment.class));
            }
        });
    }
}

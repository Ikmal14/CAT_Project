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

import java.util.Objects;

public class SecondFragment extends AppCompatActivity {

    EditText Email,Password;
    Button LoginButton;
    ProgressBar loading;
    TextView RegisterPg;
    FirebaseAuth fAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        LoginButton = findViewById(R.id.LOGIN);
        loading = findViewById(R.id.loading);
        RegisterPg = findViewById(R.id.registerPg);
        fAuth = FirebaseAuth.getInstance();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e = Email.getText().toString().trim();
                String passWord = Password.getText().toString().trim();

                if (TextUtils.isEmpty(e)) {
                    Email.setError("Email is required!");
                    return;
                }

                if (TextUtils.isEmpty(passWord)) {
                    Password.setError("Password is required!");
                    return;
                }


                if (passWord.length() < 6) {
                    Password.setError("Password must be >= 6 characters.");
                    return;
                }

                loading.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(e, passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SecondFragment.this, "Login successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), AppointmentPage.class));
                        } else {
                            Toast.makeText(SecondFragment.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                        }
                    }
                });

            }

        });

        RegisterPg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

    }
}

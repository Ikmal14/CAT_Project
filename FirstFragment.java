package com.example.HealthPointUSM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    Button login;
    Button back;
    UserObj user;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTxt = email.getText().toString();
                String passTxt = pass.getText().toString();

                if (emailTxt.isEmpty() || passTxt.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please insert all the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    myRef.orderByChild("email").equalTo(emailTxt).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                user = new UserObj();
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                    user = dataSnapshot.getValue(UserObj.class);
                                }
                                assert user != null;
                                String userEmail = user.getEmail();
                                String userPassword = user.getPassword();

                                //Check password
                                if (passTxt.equals(userPassword)) {
                                    if (userEmail.equals("111@111")) {
                                        Intent i = new Intent(Login.this, Dr_page.class);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(), "Welcome, Dr. " + user.getName(), Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Intent i = new Intent(Login.this, USER_page.class);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("name", user.getName());
                                        bundle.putString("matriks", user.getMatriks());
                                        bundle.putString("email", user.getEmail());
                                        i.putExtras(bundle);
                                        startActivity(i);
                                        Toast.makeText(getApplicationContext(), "Welcome, " + user.getName(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "No email found!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }

                    });
                }


                back = findViewById(R.id.button_second);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Login.this, Main.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}


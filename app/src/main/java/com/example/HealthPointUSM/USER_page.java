package com.example.HealthPointUSM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class USER_page extends AppCompatActivity {
    Button buttonSet, buttonShow, logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String matric = extras.getString("matriks");
            String email = extras.getString("email");
        }

        buttonSet = findViewById(R.id.setAppointment);
        buttonShow = findViewById(R.id.viewButton);
        logOut = findViewById(R.id.button_logout);

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(USER_page.this, SetAppointment.class);
                startActivity(i);
            }
        });

//        info.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(USER_page.this, Info.class);
//                startActivity(i);
//            }
//        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(USER_page.this, ShowMyAppointment.class);
                startActivity(i);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(USER_page.this, Main.class);
                startActivity(i);
            }
        });

    }
}
package com.example.HealthPointUSM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dr_page extends AppCompatActivity {
    Button logOut, upcomingApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_page);

        logOut = findViewById(R.id.button_logout);
        upcomingApp = findViewById(R.id.viewAppointment);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dr_page.this, Main.class);
                startActivity(i);
            }
        });

        upcomingApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dr_page.this, UpcomingAppointment.class);
                startActivity(i);
            }
        });

    }
}
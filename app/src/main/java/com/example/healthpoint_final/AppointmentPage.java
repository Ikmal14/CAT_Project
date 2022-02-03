package com.example.healthpoint_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class AppointmentPage extends AppCompatActivity {

    Button setAppointment, myAppointment, infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_page);

        setAppointment = findViewById(R.id.viewAppointment);
        myAppointment = findViewById(R.id.button2);
//        infoButton = findViewById(R.id.Info);


        setAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChooseDate.class));
            }
        });

        myAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MyAppointment.class ));
            }
        });

//        infoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.scrolling);
//            }
//        });
    }
}
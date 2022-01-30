package com.example.healthpoint_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DrPage extends AppCompatActivity {

    Button appointmentPg, DRfeedback, SubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_page);

        appointmentPg = findViewById(R.id.viewAppointment);

        appointmentPg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dr_check_appointment);

                DRfeedback = findViewById(R.id.feedbackDR);

                DRfeedback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(), feedback.class));
                    }
                });

            }
        });

    }

}

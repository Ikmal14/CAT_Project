package com.example.HealthPointUSM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpcomingAppointment extends AppCompatActivity {
    TextView date;
    TextView name;
//    TextView matrik;
    Button button;

    String userName;
    String appID;
    String feedback;
    String appDate;

    UserObj user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (this.getIntent().getExtras() != null)
        {
            //Get the bundle
            Bundle bundle = getIntent().getExtras();
            //Extract the data…
            userName = bundle.getString("name");
            appID = bundle.getString("appointmentId");
            feedback = bundle.getString("feedback");
            appDate = bundle.getString("date");
        }

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.dr_check_appointment);

        date = findViewById(R.id.textView9);
        name = findViewById(R.id.textView10);
//        matrik = findViewById(R.id.matrikTV);

        date.setText(sh.getString("date",""));
        name.setText(sh.getString("name",""));
//        matrik.setText(sh.getString("matriks",""));

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpcomingAppointment.this, feedback.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("name", userName);
//                bundle.putString("matriks", userMatriks);
//                bundle.putString("email", userEmail);
//                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
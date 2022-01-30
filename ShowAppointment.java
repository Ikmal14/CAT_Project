package com.example.HealthPointUSM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowAppointment extends AppCompatActivity {
    TextView date;
    TextView name;
    TextView matrik;
    Button button;

    String userName;
    String userMatriks;
    String userEmail;
    String appDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (this.getIntent().getExtras() != null)
        {
            //Get the bundle
            Bundle bundle = getIntent().getExtras();
            //Extract the data…
            userName = bundle.getString("name");
            userMatriks = bundle.getString("matriks");
            userEmail = bundle.getString("email");
            appDate = bundle.getString("date");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_appointment);

        date = findViewById(R.id.dateTV);
        name = findViewById(R.id.nameTV);
        matrik = findViewById(R.id.matrikTV);

        date.setText(appDate);
        name.setText(userName);
        matrik.setText(userMatriks);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowAppointment.this, SetAppointment.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", userName);
                bundle.putString("matriks", userMatriks);
                bundle.putString("email", userEmail);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}

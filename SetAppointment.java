package com.example.HealthPointUSM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SetAppointment extends AppCompatActivity {

    DatePicker picker;
    Button btn;
    String date;
    FirebaseDatabase database;
    DatabaseReference myRef;

    String userName;
    String userMatriks;
    String userEmail;

    //Appointment obj
    AppointmentObj app;
    String appointmentId;

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
        }

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_setappointment);
        picker = findViewById(R.id.datePicker);
        btn = findViewById(R.id.buttonSet);

        //Set appointment obj
        app = new AppointmentObj();
        app.setUserEmail(userEmail);
        app.setStatus("false");
        app.setFeedback("");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                //Pull
//                myRef.child("DOCTOR").child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DataSnapshot> task) {
//                    if (!task.isSuccessful()) {
//                        Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), String.valueOf(Objects.requireNonNull(task.getResult()).getValue()), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
                //Push
                date = picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear();
                app.setDate(date);
                appointmentId = myRef.push().getKey();
                app.setAppointmentId(appointmentId);
                myRef.child("APPOINTMENT").child(appointmentId).setValue(app);

                Intent i = new Intent(SetAppointment.this, ShowAppointment.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", userName);
                bundle.putString("matriks", userMatriks);
                bundle.putString("email", userEmail);
                bundle.putString("date", date);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        //date = picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear();
        //Toast.makeText(getApplicationContext(), ("Date set to " + date),Toast.LENGTH_SHORT).show();
    }
}

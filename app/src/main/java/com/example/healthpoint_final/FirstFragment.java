package com.example.healthpoint_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstFragment extends AppCompatActivity {

    Button LoginBtn;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        LoginBtn = findViewById(R.id.LoginPG);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstFragment.this,SecondFragment.class));

            }

        });

    }

}
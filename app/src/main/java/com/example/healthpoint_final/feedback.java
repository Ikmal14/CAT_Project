package com.example.healthpoint_final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthpoint_final.databinding.ActivityFeedbackBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.example.healthpoint_final.databinding.ActivityReadDataBinding;


public class feedback extends AppCompatActivity {

    String feedbackTxt;
    Button SubmitBtn;
    EditText form;
    ActivityFeedbackBinding binding;
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                feedbackTxt = binding.feedbackForm.getText().toString();

                if(!feedbackTxt.isEmpty()){
                    FeedbackTEXT feedbackAns = new FeedbackTEXT(feedbackTxt);
                    db = FirebaseDatabase.getInstance("https://healthpoint-0001-default-rtdb.asia-southeast1.firebasedatabase.app");
                    ref = db.getReference("FeedbackTEXT");
                    ref.child(feedbackTxt).setValue(feedbackAns).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.feedbackForm.setText("");
                            Toast.makeText(feedback.this, "Succesfully Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}
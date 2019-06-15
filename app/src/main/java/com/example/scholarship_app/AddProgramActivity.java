package com.example.scholarship_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddProgramActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProgramDatabaseReference;
    private Button mUpdateButton;
    private EditText mProgramName;
    private EditText mTime;
    private EditText mVenue;

    private String mUsername;
    private String n;
    private String t;
    private String v;
    private Program program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_program);

        StudentActivity studentActivity = new StudentActivity();
        mUsername = studentActivity.getmUsername();
        mUpdateButton = findViewById(R.id.updatebutton);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("profile");
        mUpdateButton = findViewById(R.id.updatebutton);
        mProgramName = findViewById(R.id.upname);
        mTime = findViewById(R.id.utime);
        mVenue = findViewById(R.id.uvenue);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                n = mProgramName.getText().toString();
//                t = mTime.getText().toString();
//                v = mVenue.getText().toString();
//                program = new Program(n, t, v);
                User user = new User("ABCDE","12/08/1999","RA171132",
                        "9876543210","dj123@gmail.com","AC Patil University",
                        "B. Tech", "CSE","5","2");
                mProgramDatabaseReference.push().setValue(user);
//                mProgramName.setText("");
//                mVenue.setText("");
//                mTime.setText("");

                finish();

            }
        });

    }



}

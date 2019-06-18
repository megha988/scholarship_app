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
    private EditText mTime1, mTime2, mTime3;
    private EditText mVenue;

    private String mUsername;
    private String n;
    private String t1;
    private String t2;
    private String t3;
    private String v;
    private Program program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_program);

        StudentLogin studentLogin = new StudentLogin();
        mUsername = studentLogin.getmUsername();
        mUpdateButton = findViewById(R.id.updatebutton);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("programs");
        mUpdateButton = findViewById(R.id.updatebutton);
        mProgramName = findViewById(R.id.upname);
        mTime1 = findViewById(R.id.utime1);
        mTime2 = findViewById(R.id.utime2);
        mTime3 = findViewById(R.id.utime3);
        mVenue = findViewById(R.id.uvenue);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                n = mProgramName.getText().toString();
                t1 = mTime1.getText().toString();
                t2 = mTime2.getText().toString();
                t3 = mTime3.getText().toString();
                v = mVenue.getText().toString();
                program = new Program(n, t1, t2, t3, v);
                mProgramName.setText("");
                mVenue.setText("");
                mTime1.setText("");
                mTime2.setText("");
                mTime3.setText("");
                mProgramDatabaseReference.push().setValue(program);
                finish();

            }
        });

    }



}

package com.example.scholarship_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProgramActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProgramDatabaseReference;
    private Button mUpdateButton;
    private EditText mProgramName,mDate;
    private RadioGroup mType;
    private EditText mTime1, mTime2, mTime3;
    private EditText mVenue;

    private String mUsername;
    private String type, name,date,t1,t2,t3, venue;
    private Program program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_program);

        StudentCheck studentCheck = new StudentCheck();
        mUsername = studentCheck.getmUsername();
        mUpdateButton = findViewById(R.id.updatebutton);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("programs");
        mType = findViewById(R.id.utype);
        mProgramName = findViewById(R.id.upname);
        mDate=findViewById(R.id.udate);
        mTime1 = findViewById(R.id.utime1);
        mTime2 = findViewById(R.id.utime2);
        mTime3 = findViewById(R.id.utime3);
        mVenue = findViewById(R.id.uvenue);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = findViewById(mType.getCheckedRadioButtonId());
                type = radioButton.getText().toString();
                name = mProgramName.getText().toString();
                date = mDate.getText().toString();
                t1 = mTime1.getText().toString();
                t2 = mTime2.getText().toString();
                t3 = mTime3.getText().toString();
                venue = mVenue.getText().toString();
                program = new Program(type,name,date,"", t1, t2, t3, venue, false);
                mProgramDatabaseReference.push().setValue(program);
                finish();

            }
        });

    }



}

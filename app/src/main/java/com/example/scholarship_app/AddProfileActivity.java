package com.example.scholarship_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProfileActivity extends AppCompatActivity {

    private String mUsername;
    private Button mUpdateButton;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProfileDatabaseReference;
    private EditText mName,mDOB, mRegNo,mContact, mEmail, mCollege, mCourse, mDept, mSemester,
            mBatch;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        StudentCheck studentCheck = new StudentCheck();
        mUsername = studentCheck.getmUsername();
        mUpdateButton = findViewById(R.id.profileupdatebutton);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProfileDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("profile");
        mName = findViewById(R.id.name_edittext);
        mDOB = findViewById(R.id.dob_edittext);
        mRegNo = findViewById(R.id.regno_edittext);
        mContact = findViewById(R.id.contact_edittext);
        mEmail = findViewById(R.id.email_edittext);
        mCollege = findViewById(R.id.college_edittext);
        mCourse = findViewById(R.id.course_edittext);
        mDept = findViewById(R.id.dept_edittext);
        mSemester = findViewById(R.id.semester_edittext);
        mBatch = findViewById(R.id.batch_edittext);


        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                user = new User(mName.getText().toString(),mDOB.getText().toString(),
                        mRegNo.getText().toString(),mContact.getText().toString(),
                        mEmail.getText().toString(), mCollege.getText().toString(),
                        mCourse.getText().toString(), mDept.getText().toString(),
                        mSemester.getText().toString(),
                        mBatch.getText().toString());
                mProfileDatabaseReference.setValue(null);
                mProfileDatabaseReference.push().setValue(user);
                finish();


            }
        });

    }
}

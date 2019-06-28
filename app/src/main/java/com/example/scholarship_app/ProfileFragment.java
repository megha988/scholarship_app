package com.example.scholarship_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProfileDatabaseReference;
    private ChildEventListener mChildEventListener;
    private String mUsername;
    private FloatingActionButton mFloatingActionButton;
    private TextView mHeadingName,mName,mDOB, mRegNo,mContact, mEmail, mCollege, mCourse, mDept, mSemester,
            mBatch;
    StudentCheck studentCheck = new StudentCheck();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mUsername = studentCheck.getmUsername();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProfileDatabaseReference = mFirebaseDatabase.getReference()
                                    .child(mUsername)
                                        .child("profile");

        mName = view.findViewById(R.id.username_text_view);
        mHeadingName = view.findViewById(R.id.name_text_view);
        mDOB = view.findViewById(R.id.dob_text_view);
        mRegNo = view.findViewById(R.id.regno_text_view);
        mContact = view.findViewById(R.id.contact_text_view);
        mEmail = view.findViewById(R.id.email_text_view);
        mCollege = view.findViewById(R.id.college_text_view);
        mCourse = view.findViewById(R.id.program_text_view);
        mDept = view.findViewById(R.id.dept_text_view);
        mSemester = view.findViewById(R.id.semester_text_view);
        mBatch = view.findViewById(R.id.batch_text_view);
        mFloatingActionButton = view.findViewById(R.id.addprofile);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                User user = dataSnapshot.getValue(User.class);
                mHeadingName.setText(user.getName());
                mName.setText(user.getName());
                mDOB.setText(user.getDob());
                mRegNo.setText("Reg. No.: "+user.getRegno());
                mContact.setText(user.getContact());
                mEmail.setText(user.getEmail());
                mCollege.setText(user.getCollege());
                mCourse.setText(user.getCourse());
                mDept.setText(user.getDepartment());
                mSemester.setText(user.getSemester());
                mBatch.setText(user.getBatch());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
                mName.setText(user.getName());
                mDOB.setText(user.getDob());
                mRegNo.setText(user.getRegno());
                mContact.setText(user.getContact());
                mEmail.setText(user.getEmail());
                mCollege.setText(user.getCollege());
                mCourse.setText(user.getCourse());
                mDept.setText(user.getDepartment());
                mSemester.setText(user.getSemester());
                mBatch.setText(user.getBatch());

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mProfileDatabaseReference.addChildEventListener(mChildEventListener);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddProfileActivity.class));
            }
        });



        return view;
    }

}

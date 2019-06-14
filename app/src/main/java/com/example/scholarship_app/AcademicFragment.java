package com.example.scholarship_app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMarksDatabaseReference;
    private ChildEventListener mChildEventListener;
    private Button mUpdateButton;
    private EditText M1,M2,M3,M4,M5,M6,M7,M8;
//    private int flag = 0;

    private String mUsername;
    private String m1,m2,m3,m4,m5,m6,m7,m8;
    private Marks marks;


    public AcademicFragment() {
        // Required empty public constructor
    }

    private void TCL(final EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                        mUpdateButton.setEnabled(true);

                }
                else {
                    mUpdateButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(editText.getText().toString().trim().length() > 0) {
                    mUpdateButton.setEnabled(true);
                }
                else {
                    mUpdateButton.setEnabled(false);
                }

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_academic, container, false);

        mUsername = "ANONYMOUS";
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMarksDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("marks");
        mUpdateButton = view.findViewById(R.id.updatebutton);
        M1 = view.findViewById(R.id.M1);
        M2 = view.findViewById(R.id.M2);
        M3 = view.findViewById(R.id.M3);
        M4 = view.findViewById(R.id.M4);
        M5 = view.findViewById(R.id.M5);
        M6 = view.findViewById(R.id.M6);
        M7 = view.findViewById(R.id.M7);
        M8 = view.findViewById(R.id.M8);

        TCL(M1);
        TCL(M2);
        TCL(M3);
        TCL(M4);
        TCL(M5);
        TCL(M6);
        TCL(M7);
        TCL(M8);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                Marks marks = dataSnapshot.getValue(Marks.class);
                M1.setText(marks.getS1M());
                M2.setText(marks.getS2M());
                M3.setText(marks.getS3M());
                M4.setText(marks.getS4M());
                M5.setText(marks.getS5M());
                M6.setText(marks.getS6M());
                M7.setText(marks.getS7M());
                M8.setText(marks.getS8M());


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

        mMarksDatabaseReference.addChildEventListener(mChildEventListener);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMarksDatabaseReference.setValue(null);

                m1 = M1.getText().toString();
                m2 = M2.getText().toString();
                m3 = M3.getText().toString();
                m4 = M4.getText().toString();
                m5 = M5.getText().toString();
                m6 = M6.getText().toString();
                m7 = M7.getText().toString();
                m8 = M8.getText().toString();

                marks = new Marks(m1,m2,m3,m4,m5,m6,m7,m8);
                mMarksDatabaseReference.push().setValue(marks);
                M8.clearFocus();

            }
        });




        return view;

    }

}

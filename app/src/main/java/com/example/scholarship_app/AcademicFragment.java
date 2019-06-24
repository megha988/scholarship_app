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
import android.widget.TextView;

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
    private EditText M1,M2,M3,M4,M5,M6,M7,M8,SGPA1,SGPA2,SGPA3,SGPA4,SGPA5,SGPA6,SGPA7,SGPA8;
    StudentLogin studentLogin = new StudentLogin();
//    private int flag = 0;

    private String mUsername;
    private String m1,m2,m3,m4,m5,m6,m7,m8,sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8;
    private Marks marks;


    public AcademicFragment() {
        // Required empty public constructor
    }

    private void echeck(EditText editText){

    if(editText.getText().toString().equals(""))
          editText.setEnabled(true);
    else
        editText.setEnabled(false);
    }

    private void TCL(final TextView textView) {

        textView.addTextChangedListener(new TextWatcher() {
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

                if(textView.getText().toString().trim().length() > 0) {
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

        mUsername = studentLogin.getmUsername();
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
        SGPA1 = view.findViewById(R.id.SGPA1);
        SGPA2 = view.findViewById(R.id.SGPA2);
        SGPA3 = view.findViewById(R.id.SGPA3);
        SGPA4 = view.findViewById(R.id.SGPA4);
        SGPA5 = view.findViewById(R.id.SGPA5);
        SGPA6 = view.findViewById(R.id.SGPA6);
        SGPA7 = view.findViewById(R.id.SGPA7);
        SGPA8 = view.findViewById(R.id.SGPA8);

//        TCL(M1);
//        TCL(M2);
//        TCL(M3);
//        TCL(M4);
//        TCL(M5);
//        TCL(M6);
//        TCL(M7);
//        TCL(M8);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                Marks marks = dataSnapshot.getValue(Marks.class);
                M1.setText(marks.getS1M());
                echeck(M1);
                M2.setText(marks.getS2M());
                echeck(M2);
                M3.setText(marks.getS3M());
                echeck(M3);
                M4.setText(marks.getS4M());
                echeck(M4);
                M5.setText(marks.getS5M());
                echeck(M5);
                M6.setText(marks.getS6M());
                echeck(M6);
                M7.setText(marks.getS7M());
                echeck(M7);
                M8.setText(marks.getS8M());
                echeck(M8);
                SGPA1.setText(marks.getSGPA1());
                echeck(SGPA1);
                SGPA2.setText(marks.getSGPA2());
                echeck(SGPA2);
                SGPA3.setText(marks.getSGPA3());
                echeck(SGPA3);
                SGPA4.setText(marks.getSGPA4());
                echeck(SGPA4);
                SGPA5.setText(marks.getSGPA5());
                echeck(SGPA5);
                SGPA6.setText(marks.getSGPA6());
                echeck(SGPA6);
                SGPA7.setText(marks.getSGPA7());
                echeck(SGPA7);
                SGPA8.setText(marks.getSGPA8());
                echeck(SGPA8);


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
                sgpa1 = SGPA1.getText().toString();
                sgpa2 = SGPA2.getText().toString();
                sgpa3 = SGPA3.getText().toString();
                sgpa4 = SGPA4.getText().toString();
                sgpa5 = SGPA5.getText().toString();
                sgpa6 = SGPA6.getText().toString();
                sgpa7 = SGPA7.getText().toString();
                sgpa8 = SGPA8.getText().toString();

                marks = new Marks(m1,m2,m3,m4,m5,m6,m7,m8,sgpa1,sgpa2,sgpa3,sgpa4,sgpa5,sgpa6,sgpa7,sgpa8);
                mMarksDatabaseReference.push().setValue(marks);
//                M8.clearFocus();

            }
        });




        return view;

    }

}

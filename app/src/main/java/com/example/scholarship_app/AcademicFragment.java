package com.example.scholarship_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMarksDatabaseReference;
    private ChildEventListener mChildEventListener;
    private Button mUpdateButton;
    private EditText mUpdateMarks;

    private String mUsername;
    private String m;
    private Marks marks;


    public AcademicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_academic, container, false);

        mUsername = "ANONYMOUS";
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMarksDatabaseReference = mFirebaseDatabase.getReference().child("marks");
        mUpdateButton = view.findViewById(R.id.updatebutton);
        mUpdateMarks = view.findViewById(R.id.M1);

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m = mUpdateMarks.getText().toString();
                marks = new Marks(m, mUsername);
                mMarksDatabaseReference.push().setValue(marks);
                mUpdateMarks.clearFocus();

            }
        });

        return view;

    }

}

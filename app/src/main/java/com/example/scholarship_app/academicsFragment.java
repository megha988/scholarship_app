package com.example.scholarship_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class academicsFragment extends Fragment {


    public academicsFragment() {
        // Required empty public constructor
    }

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMarksDatabaseReference;
    private Button mUpdateButton;
    private EditText mUpdateMarks;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_academics, container, false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMarksDatabaseReference = mFirebaseDatabase.getReference().child("marks");
        mUpdateButton = v.findViewById(R.id.updatebutton);
        mUpdateMarks = v.findViewById(R.id.M1);



        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mUpdateMarks.setText("25");

            }
        });

        return v;
    }

}

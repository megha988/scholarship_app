package com.example.scholarship_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends Fragment {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProgramDatabaseReference;
    private ChildEventListener mChildEventListener;
    private FloatingActionButton mAddButton;
    private ProgramAdapter mProgramAdapter;

    private String mUsername;
    StudentActivity studentActivity = new StudentActivity();
    private ArrayList<Program> plist = new ArrayList<>();


    public ProgramFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program, container, false);

        mUsername = studentActivity.getmUsername();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("programs");
        mAddButton = view.findViewById(R.id.addbutton);
        mProgramAdapter = new ProgramAdapter(getActivity(), plist);

        ListView listView = view.findViewById(R.id.list);

        listView.setAdapter(mProgramAdapter);






        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                Program mProgram = dataSnapshot.getValue(Program.class);
                mProgramAdapter.add(mProgram);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        };

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),AddProgramActivity.class);
                startActivity(intent);

            }
        });

        mProgramDatabaseReference.addChildEventListener(mChildEventListener);


        return view;

    }


}

package com.example.scholarship_app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private Button mUpdateButton;
    private EditText mProgramName;
    private EditText mTime;
    private EditText mVenue;
    private ProgramAdapter mProgramAdapter;

    private String mUsername;
    private String n;
    private String t;
    private String v;
    private Program program;
    private ArrayList<Program> plist = new ArrayList<>();


    public ProgramFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program, container, false);

        mUsername = "ANONYMOUS";
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("programs");
        mUpdateButton = view.findViewById(R.id.updatebutton);
        mProgramName = view.findViewById(R.id.upname);
        mTime = view.findViewById(R.id.utime);

        mVenue = view.findViewById(R.id.uvenue);

        mProgramAdapter = new ProgramAdapter(getActivity(), plist);

        ListView listView = view.findViewById(R.id.list);

        listView.setAdapter(mProgramAdapter);



        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                n = mProgramName.getText().toString();
                t = mTime.getText().toString();
                v = mVenue.getText().toString();
                program = new Program(n, t, v);
//                User user = new User("David Jones","12/08/1999","RA171132",
//                        "9876543210","dj123@gmail.com","AC Patil University",
//                        "B. Tech", "CSE","5","2");
                mProgramDatabaseReference.push().setValue(program);
                mProgramName.setText("");
                mVenue.setText("");
                mTime.setText("");

            }
        });



        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {

                Program mProgram = dataSnapshot.getValue(Program.class);
                mProgramAdapter.add(mProgram);

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

        mProgramDatabaseReference.addChildEventListener(mChildEventListener);


        return view;

    }


}

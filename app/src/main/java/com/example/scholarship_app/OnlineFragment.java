package com.example.scholarship_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFragment extends Fragment {


    public OnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_online, container, false);

        ArrayList<Program> word = new ArrayList<>();
        word.add(new Program("ABC","12.30","TP106"));
        word.add(new Program("DEF","1.30","TP107"));
        word.add(new Program("GHI","2.30","TP108"));
        word.add(new Program("GHI","2.30","TP108"));
        word.add(new Program("GHI","2.30","TP108"));
        word.add(new Program("GHI","2.30","TP108"));

        ProgramAdapter iA = new ProgramAdapter(getActivity(), word);

        ListView listView = v.findViewById(R.id.list);

        listView.setAdapter(iA);

        return v;

    }


}

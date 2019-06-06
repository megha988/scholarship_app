package com.example.scholarship_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class academicsFragment extends Fragment {

    Spinner sem;

    int sno[] = {1,2,3,4,5,6,7,8};

    ArrayAdapter<String> adapter;
    int record = 0;
    TextView display_data;


    public academicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_academics, container, false);

//        sem = v.findViewById(R.id.spinner);
//
//        adapter = new  ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
//
//        sem.setAdapter(adapter);
//
//        display_data = v.findViewById(R.id.mark);
//
//        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                switch (i) {
//
//                    case 0:
//                        record = 1;
//                        break;
//
//                    case 1:
//                        record = 2;
//                        break;
//
//                    case 2:
//                        record = 3;
//                        break;
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });
        return v;
    }

    public void mark(View view) {
        display_data.setText(record);
    }


}

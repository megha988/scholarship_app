package com.example.scholarship_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ProgramAdapter extends ArrayAdapter<Program> {

    public ProgramAdapter (Activity context, ArrayList<Program> program) {
        super(context, 0, program);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Program currentProgram = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.cName);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentProgram.getmCourseName());

        RadioButton radbut;
        radbut = listItemView.findViewById(R.id.radio1);
        radbut.setText(currentProgram.getmTime1());
        radbut = listItemView.findViewById(R.id.radio2);
        radbut.setText(currentProgram.getmTime2());
        radbut = listItemView.findViewById(R.id.radio3);
        radbut.setText(currentProgram.getmTime3());

        RadioGroup radioGroup = listItemView.findViewById(R.id.slot_selection);
        RadioButton rb = listItemView.findViewById(radioGroup.getCheckedRadioButtonId());
//        RadioButton radioButton = listItemView.findViewById(radioGroup.getCheckedRadioButtonId());

        // Find the TextView in the list_item.xml layout with the ID version_number
        final TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

        timeTextView.setText("Time: "+rb.getText());


                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        RadioButton radioButton = radioGroup.findViewById(i);

                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                timeTextView.setText("Time: "+radioButton.getText());
            }
        });

        TextView venueTextView = (TextView) listItemView.findViewById(R.id.venue);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        venueTextView.setText("Venue: "+currentProgram.getmVenue());



        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

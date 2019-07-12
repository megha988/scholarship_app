package com.example.scholarship_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ProgramAdapter extends ArrayAdapter<Program> {


    private Program currentProgram;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProgramDatabaseReference;
    private RadioButton rb;
    private String key;
    private String mUsername;
    private RadioGroup radioGroup;
//    private TextView nameTextView;
    private int pos;
    private View listItemView;
    private StudentCheck studentCheck = new StudentCheck();




    public ProgramAdapter(Activity context, ArrayList<Program> program) {
        super(context, 0, program);
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        mUsername = studentCheck.getmUsername();
        currentProgram = getItem(position);
        key = currentProgram.getKey();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername)
                .child("programs");


        final TextView nameTextView = listItemView.findViewById(R.id.cName);

        pos = position;

        RadioButton radbut;
        radbut = listItemView.findViewById(R.id.radio1);
        radbut.setText(currentProgram.getmTime1());
        radbut = listItemView.findViewById(R.id.radio2);
        radbut.setText(currentProgram.getmTime2());
        radbut = listItemView.findViewById(R.id.radio3);
        radbut.setText(currentProgram.getmTime3());

        radioGroup = listItemView.findViewById(R.id.slot_selection);




        final TextView timeTextView = listItemView.findViewById(R.id.time);
        rb = listItemView.findViewById(radioGroup.getCheckedRadioButtonId());

        TextView venueTextView = listItemView.findViewById(R.id.venue);
        venueTextView.setText("Venue: " + currentProgram.getmVenue());

        TextView  typeTextView =listItemView.findViewById(R.id.type_text_view);
        typeTextView.setText(currentProgram.getmType());

        TextView  dateTextView =listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText("Date: "+currentProgram.getmDate());




        if (currentProgram.isFlag() == false) {

            timeTextView.setText("Time: " + rb.getText());

            nameTextView.setText(currentProgram.getmCourseName());

            radioGroup.setTag(position);


            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(final RadioGroup radioGroup, int i) {

                    int position = (Integer) radioGroup.getTag();
                    currentProgram = getItem(position);

                    RadioButton radioButton = radioGroup.findViewById(i);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(listItemView.getContext());
                    alertDialogBuilder.setMessage("Are you sure you want to select "
                            + radioButton.getText() + "?");

                    alertDialogBuilder.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {

                                radioGroup.setVisibility(View.GONE);
//                                nameTextView.setText(currentProgram.getmTime());
                                mProgramDatabaseReference.child(currentProgram.getKey()).child("flag").setValue(true);
                                mProgramDatabaseReference.child(currentProgram.getKey()).child("mTime")
                                        .setValue(currentProgram.getmTime());
                                }
                            });
                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                    currentProgram.setmTime(radioButton.getText().toString());

                    timeTextView.setText("Time: " + currentProgram.getmTime());
                }
            });



        } else {
            nameTextView.setText(currentProgram.getmCourseName());
            timeTextView.setText("Time: " + currentProgram.getmTime());
            radioGroup.setVisibility(View.GONE);
        }



        return listItemView;
    }


}

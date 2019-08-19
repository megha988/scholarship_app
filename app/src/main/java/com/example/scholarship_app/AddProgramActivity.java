package com.example.scholarship_app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddProgramActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener,
        View.OnClickListener{

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mProgramDatabaseReference;
    private Button mUpdateButton;
    private EditText mProgramName,mDate;
    private RadioGroup mType;
    private EditText mVenue;
    private EditText mTime1,mTime2, mTime3;

    private String mUsername;
    private String type, name,date,t,t1,t2,t3, venue;
    private Program program;

    static EditText editTextView;

    @Override
    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
        m+=1;
        String year = Integer.toString(y);
        String month = Integer.toString(m);
        String day = Integer.toString(d);
        if (d<10)
            day=0+day;
        if (m<10)
            month=0+month;
        date = day+"/"+month+"/"+year;
        mDate.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hr, int min) {
        String timeSet;
        if (hr > 12) {
            hr -= 12;
            timeSet = "PM";
        } else if (hr == 0) {
            hr += 12;
            timeSet = "AM";
        } else if (hr == 12){
            timeSet = "PM";
        }else{
            timeSet = "AM";
        }
        String hour;
        if (hr < 10)
            hour = "0" + hr ;
        else
            hour = String.valueOf(hr);
        String minutes;
        if (min < 10)
            minutes = "0" + min ;
        else
            minutes = String.valueOf(min);
        t=hour+":"+minutes+" "+timeSet;
        editTextView.setText(t);
    }

    @Override
    public void onClick(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                AddProgramActivity.this,
                AddProgramActivity.this,
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();

        switch (view.getId()) {
            case R.id.utime1:
                editTextView =findViewById(R.id.utime1);
                break;
            case R.id.utime2:
                editTextView =findViewById(R.id.utime2);
                break;
            case R.id.utime3:
                editTextView =findViewById(R.id.utime3);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_program);

        StudentCheck studentCheck = new StudentCheck();
        mUsername = studentCheck.getmUsername();
        mUpdateButton = findViewById(R.id.updatebutton);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mProgramDatabaseReference = mFirebaseDatabase.getReference().child(mUsername).child("programs");
        mType = findViewById(R.id.utype);
        mProgramName = findViewById(R.id.upname);
        mDate=findViewById(R.id.udate);
        mTime1 = findViewById(R.id.utime1);
        mTime2 = findViewById(R.id.utime2);
        mTime3 = findViewById(R.id.utime3);
        mVenue = findViewById(R.id.uvenue);

//        mDate.setClickable(true);
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddProgramActivity.this,
                        AddProgramActivity.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();

            }
        });

        mTime1.setOnClickListener(AddProgramActivity.this);
        mTime2.setOnClickListener(AddProgramActivity.this);
        mTime3.setOnClickListener(AddProgramActivity.this);


        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = findViewById(mType.getCheckedRadioButtonId());
                type = radioButton.getText().toString();
                name = mProgramName.getText().toString();
                date = mDate.getText().toString();
                t1 = mTime1.getText().toString();
                t2 = mTime2.getText().toString();
                t3 = mTime3.getText().toString();
                venue = mVenue.getText().toString();
                program = new Program(type,name,date,"", t1, t2, t3, venue, false);
                mProgramDatabaseReference.push().setValue(program);
                finish();

            }
        });

    }
}

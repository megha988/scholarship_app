package com.example.scholarship_app;

import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Program {

    public Program()
    {}

    private String mCourseName;
    private String mTime1;
    private String mTime2;
    private String mTime3;
    private String mVenue;

    public Program(String mCourseName, String mTime1, String mTime2, String mTime3, String mVenue) {
        this.mCourseName = mCourseName;
        this.mTime1 = mTime1;
        this.mTime2 = mTime2;
        this.mTime3 = mTime3;
        this.mVenue = mVenue;
    }



    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmTime1() {
        return mTime1;
    }

    public void setmTime1(String mTime1) {
        this.mTime1 = mTime1;
    }

    public String getmTime2() {
        return mTime2;
    }

    public void setmTime2(String mTime2) {
        this.mTime2 = mTime2;
    }

    public String getmTime3() {
        return mTime3;
    }

    public void setmTime3(String mTime3) {
        this.mTime3 = mTime3;
    }

    public String getmVenue() {
        return mVenue;
    }

    public void setmVenue(String mVenue) {
        this.mVenue = mVenue;
    }
}

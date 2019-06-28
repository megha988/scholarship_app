package com.example.scholarship_app;

import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Program {

    public Program()
    {}

    private String mCourseName;
    private String Key;
    private boolean flag;
    private String mType;
    private String mDate;
    private String mTime;
    private String mTime1;
    private String mTime2;
    private String mTime3;
    private String mVenue;


    public Program(String mType,String mCourseName, String mDate, String mTime, String mTime1, String mTime2, String mTime3, String mVenue, boolean flag) {
        this.mCourseName = mCourseName;
        this.mType = mType;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mTime1 = mTime1;
        this.mTime2 = mTime2;
        this.mTime3 = mTime3;
        this.mVenue = mVenue;
        this.flag = flag;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmTime() { return mTime; }

    public void setmTime(String mTime) { this.mTime = mTime; }

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

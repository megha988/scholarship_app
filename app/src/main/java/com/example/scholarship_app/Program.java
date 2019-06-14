package com.example.scholarship_app;

public class Program {

    public Program()
    {}

    private String mCourseName;
    private String mTime;
    private String mVenue;

    public Program(String mCourseName, String mTime, String mVenue) {
        this.mCourseName = mCourseName;
        this.mTime = mTime;
        this.mVenue = mVenue;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmVenue() {
        return mVenue;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public void setmVenue(String mVenue) {
        this.mVenue = mVenue;
    }
}

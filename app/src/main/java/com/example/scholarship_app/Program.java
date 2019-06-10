package com.example.scholarship_app;

public class Program {

    private String mCourseName;
    private String mTime;
    private String mVenue;

    public Program(String courseName, String time, String venue) {
        mCourseName = courseName;
        mTime = time;
        mVenue = venue;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public String getTime() {
        return mTime;
    }

    public String getVenue() {
        return mVenue;
    }


}

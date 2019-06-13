package com.example.scholarship_app;

public class Marks {

    private String marks;
    private String name;
//    private String photoUrl;

    public Marks() {
    }

    public Marks(String marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

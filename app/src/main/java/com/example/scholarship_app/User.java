package com.example.scholarship_app;

public class User {

    public User() {
    }

    private String name;
    private String dob;
    private String regno;
    private String contact;
    private String email;
    private String college;
    private String course;
    private String department;
    private String semester;
    private String batch;

    public User (String name, String dob, String regno, String contact, String email,
                 String college, String course, String department, String semester, String batch) {
        this.name = name;
        this.dob = dob;
        this.regno = regno;
        this.contact = contact;
        this.email = email;
        this.college = college;
        this.course = course;
        this.department = department;
        this.semester = semester;
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}

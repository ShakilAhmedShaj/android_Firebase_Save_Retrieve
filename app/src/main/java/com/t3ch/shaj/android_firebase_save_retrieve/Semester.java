package com.t3ch.shaj.android_firebase_save_retrieve;

/**
 * Created by Shakil Ahmed Shaj on 16-Oct-18.
 */
public class Semester {

    private String studentid;
    private String studentSemester;
    private double studentCGPA;

    public Semester() {
    }

    public Semester(String studentid, String studentSemester, double studentCGPA) {
        this.studentid = studentid;
        this.studentSemester = studentSemester;
        this.studentCGPA = studentCGPA;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public double getStudentCGPA() {
        return studentCGPA;
    }
}

//done
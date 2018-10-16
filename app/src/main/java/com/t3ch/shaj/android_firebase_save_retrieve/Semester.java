package com.t3ch.shaj.android_firebase_save_retrieve;

/**
 * Created by Shakil Ahmed Shaj on 16-Oct-18.
 */
public class Semester {

    private String studentid;
    private String studentSemester;
    private String studentCGPA;

    public Semester() {
    }

    public Semester(String studentid, String studentSemester, String studentCGPA) {
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

    public String getStudentCGPA() {
        return studentCGPA;
    }
}

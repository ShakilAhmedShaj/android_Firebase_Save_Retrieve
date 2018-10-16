package com.t3ch.shaj.android_firebase_save_retrieve;

/**
 * Created by Shakil Ahmed Shaj on 16-Oct-18.
 */
public class Student {

    String id;
    String name;
    String department;


    public Student(){}

    public Student(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

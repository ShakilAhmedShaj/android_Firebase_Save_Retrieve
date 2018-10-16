package com.t3ch.shaj.android_firebase_save_retrieve;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 16-Oct-18.
 */
public class SemesterList extends ArrayAdapter<Semester> {
    private Activity context;
    private List<Semester> semesters;

    public SemesterList(Activity context, List<Semester> semesters) {


        super(context, R.layout.semester_layout, semesters);
        this.context = context;
        this.semesters = semesters;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.semester_layout, null, true);

        TextView textViewSemester = listViewItem.findViewById(R.id.textViewSemester);
        TextView TextViewCGPA = listViewItem.findViewById(R.id.textViewCGPA);

        Semester semester = semesters.get(position);
        textViewSemester.setText(semester.getStudentSemester());
        //TextViewCGPA.setText(semester.getStudentCGPA());
        TextViewCGPA.setText(String.valueOf(semester.getStudentCGPA()));

        return listViewItem;

    }

}

//done

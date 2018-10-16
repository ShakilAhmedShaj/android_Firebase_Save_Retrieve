package com.t3ch.shaj.android_firebase_save_retrieve;

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
public class StudentList extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public StudentList(Activity context, List<Student> studentList) {


        super(context, R.layout.list_layout,studentList);
        this.context = context;
        this.studentList = studentList;

    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView deptTextView = listViewItem.findViewById(R.id.textViewDepartment);

        Student student = studentList.get(position);
        textViewName.setText(student.getName());
        deptTextView.setText(student.getDepartment());

        return listViewItem;

    }
}

package com.t3ch.shaj.android_firebase_save_retrieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText studentName;
    private Button addStudent;
    private Spinner deparments;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentName = findViewById(R.id.editTextNameID);
        addStudent = findViewById(R.id.addStudentID);
        deparments = findViewById(R.id.departmentID);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentInfo();
            }
        });


    }

    private void addStudentInfo() {


        String name = studentName.getText().toString().trim();
        String department = deparments.getSelectedItem().toString().trim();

        if (!TextUtils.isEmpty(name)) {


        } else {
            Toast.makeText(MainActivity.this, "Name is emty", Toast.LENGTH_LONG).show();

        }


    }
}

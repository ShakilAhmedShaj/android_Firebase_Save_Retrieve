package com.t3ch.shaj.android_firebase_save_retrieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText studentName;
    private Button addStudent;
    private Spinner departments;

    DatabaseReference databaseStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseStudent = FirebaseDatabase.getInstance().getReference("student");


        studentName = findViewById(R.id.editTextNameID);
        addStudent = findViewById(R.id.addStudentID);
        departments = findViewById(R.id.departmentID);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentInfo();
            }
        });


    }

    private void addStudentInfo() {


        String name = studentName.getText().toString().trim();
        String department = departments.getSelectedItem().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseStudent.push().getKey();
            Student student = new Student(id, name, department);
            databaseStudent.child(id).setValue(student);

            Toast.makeText(MainActivity.this, "New Student Added", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(MainActivity.this, "Name is emty", Toast.LENGTH_LONG).show();

        }


    }
}

package com.t3ch.shaj.android_firebase_save_retrieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSemester extends AppCompatActivity {

    private TextView studentName;
    private Spinner studentSemester;
    private EditText studentCGPA;
    private Button addSemesterBTN;

    DatabaseReference databaseSemester;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_semester);

        studentName = findViewById(R.id.textViewStudentName);
        studentSemester = findViewById(R.id.semesterID);
        studentCGPA = findViewById(R.id.studentCGPA_edit_id);
        addSemesterBTN = findViewById(R.id.addSemesterButtonID);


        Intent intent = getIntent();
        String id = intent.getStringExtra(MainActivity.STUDENT_ID);
        String name = intent.getStringExtra(MainActivity.STUDENT_NAME);

        studentName.setText(name);

        databaseSemester = FirebaseDatabase.getInstance().getReference("semester").child(id);

        addSemesterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveSemester();

            }
        });


    }

    private void saveSemester() {

        String semester = studentSemester.getSelectedItem().toString().trim();
        String cgpa = studentCGPA.getText().toString().trim();

        if (!TextUtils.isEmpty(cgpa)) {
            String id = databaseSemester.push().getKey();
            Semester semesterValue = new Semester(id, semester, cgpa);

            databaseSemester.child(id).setValue(semesterValue);

            Toast.makeText(AddSemester.this, "Semester Saved", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(AddSemester.this, "Semester not Saved", Toast.LENGTH_LONG).show();
        }

    }
}

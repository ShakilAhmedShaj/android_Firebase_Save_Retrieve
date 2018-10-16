package com.t3ch.shaj.android_firebase_save_retrieve;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String STUDENT_NAME = "studentName";
    public static final String STUDENT_ID = "studentID";


    private EditText studentName;
    private Button addStudent;
    private Spinner departments;

    DatabaseReference databaseStudent;

    ListView listView;

    List<Student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseStudent = FirebaseDatabase.getInstance().getReference("student");


        studentName = findViewById(R.id.editTextNameID);
        addStudent = findViewById(R.id.addStudentID);
        departments = findViewById(R.id.departmentID);

        listView = findViewById(R.id.listView_student_id);

        studentList = new ArrayList<>();

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentInfo();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Student student = studentList.get(position);
                Intent intent = new Intent(getApplicationContext(), AddSemester.class);

                intent.putExtra(STUDENT_ID, student.getId());
                intent.putExtra(STUDENT_NAME, student.getName());
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        databaseStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();

                for (DataSnapshot studentsnapshot : dataSnapshot.getChildren()) {
                    Student student = studentsnapshot.getValue(Student.class);
                    studentList.add(student);
                }

                StudentList adapter = new StudentList(MainActivity.this, studentList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
            Toast.makeText(MainActivity.this, "Name is empty", Toast.LENGTH_LONG).show();

        }


    }
}

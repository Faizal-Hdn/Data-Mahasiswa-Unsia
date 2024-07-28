package com.example.studentmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Map;
import com.example.studentmanagementapp.model.Student;
import com.example.studentmanagementapp.view.AddStudentActivity;

import com.example.studentmanagementapp.view.StudentListAdapter;

public class MainActivity extends AppCompatActivity {

    private Button addStudentButton;
    private Button removeStudentButton;
    private ListView studentListView;
    private StudentListAdapter adapter;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addStudentButton = findViewById(R.id.add_student_button);
        removeStudentButton = findViewById(R.id.remove_student_button);
        studentListView = findViewById(R.id.student_list);

        students = new ArrayList<>();
        adapter = new StudentListAdapter(this, students);
        studentListView.setAdapter(adapter);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });

        removeStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllStudents();
                Toast.makeText(MainActivity.this, "All Students Removed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadStudentData();
    }

    private void loadStudentData() {
        SharedPreferences sharedPreferences = getSharedPreferences("StudentData", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();
        students.clear();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String[] data = entry.getValue().toString().split(",");
            if (data.length == 2) {
                students.add(new Student(entry.getKey(), data[0], data[1]));
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void removeAllStudents() {
        SharedPreferences sharedPreferences = getSharedPreferences("StudentData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        students.clear();
        adapter.notifyDataSetChanged();
    }
}

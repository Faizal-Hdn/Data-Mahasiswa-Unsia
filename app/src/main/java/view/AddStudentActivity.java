package com.example.studentmanagementapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentmanagementapp.R;

public class AddStudentActivity extends AppCompatActivity {

    private EditText studentName;
    private EditText studentId;
    private EditText studentMajor;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentName = findViewById(R.id.student_name);
        studentId = findViewById(R.id.student_id);
        studentMajor = findViewById(R.id.student_major);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = studentName.getText().toString();
                String id = studentId.getText().toString();
                String major = studentMajor.getText().toString();

                if (!name.isEmpty() && !id.isEmpty() && !major.isEmpty()) {
                    // Save student data to SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("StudentData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(id, name + "," + major);
                    editor.apply();

                    // Finish this activity and go back to MainActivity
                    finish();
                }
            }
        });
    }
}

package com.example.studentmanagementapp.view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.studentmanagementapp.R;
import java.util.ArrayList;

public class StudentListAdapter extends ArrayAdapter<com.example.studentmanagementapp.model.Student> {
    private Context context;
    private ArrayList<com.example.studentmanagementapp.model.Student> students;

    public StudentListAdapter(Context context, ArrayList<com.example.studentmanagementapp.model.Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);
        }

        com.example.studentmanagementapp.model.Student student = students.get(position);

        TextView studentIdView = convertView.findViewById(R.id.student_id);
        TextView studentNameView = convertView.findViewById(R.id.student_name);
        TextView studentMajorView = convertView.findViewById(R.id.student_major);

        studentIdView.setText(((com.example.studentmanagementapp.model.Student) student).getId());
        studentNameView.setText(((com.example.studentmanagementapp.model.Student) student).getName());
        studentMajorView.setText(((com.example.studentmanagementapp.model.Student) student).getMajor());

        return convertView;
    }
}

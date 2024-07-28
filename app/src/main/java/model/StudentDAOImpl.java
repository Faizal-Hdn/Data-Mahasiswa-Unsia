package com.example.studentmanagementapp.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private List<Student> students;

    public StudentDAOImpl() {
        students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(String studentId) {
        students.removeIf(student -> student.getId().equals(studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}


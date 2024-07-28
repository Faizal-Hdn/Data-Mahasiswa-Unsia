package com.example.studentmanagementapp.model;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);
    void removeStudent(String studentId);
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
}


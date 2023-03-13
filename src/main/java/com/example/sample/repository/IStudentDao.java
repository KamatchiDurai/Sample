package com.example.sample.repository;

import com.example.sample.model.Student;

import java.util.Map;

public interface IStudentDao {

    void saveStudent(Student student);
    Student getOneStudent(Integer id);
    void updateStudent(Student student);
    Map<Integer, Student> getAllStudents();
    void deleteStudent(Integer id);
    void saveAllStudents(Map<Integer, Student> map);

}

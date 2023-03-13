package com.example.sample.model;

import com.example.sample.model.Grade;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
public class StudentGrade implements Serializable {

    public int studentNumber;
    public List<Grade> grades;

    public StudentGrade(int studentNumber, List<Grade> grades) {
        this.studentNumber = studentNumber;
        this.grades = grades;
    }

    public StudentGrade() {

    }
}

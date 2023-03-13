package com.example.sample.model;

import com.example.sample.model.Address;
import com.example.sample.model.Grade;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class Student implements Serializable {

    public String studentId;
    public StudentAccount studentAccount;
    public StudentAddress address;
    public StudentGrade studentGrade;

    public Student(String studentId,StudentAccount studentAccount, StudentAddress address, StudentGrade studentGrade) {
        this.studentId = studentId;
        this.studentAccount = studentAccount;
        this.address = address;
        this.studentGrade = studentGrade;
    }

    public Student() {
    }
}

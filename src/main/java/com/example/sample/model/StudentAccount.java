package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StudentAccount implements Serializable {

    @SerializedName("studentNumber")
    public String studentNumber;

    @SerializedName("firstName")
    public String firstName;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @SerializedName("lastName")
    public String lastName;

    @SerializedName("phoneNumber")
    public String phoneNumber;

    public StudentAccount(String studentNumber, String firstName, String lastName, String phoneNumber) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public StudentAccount() {
    }
}

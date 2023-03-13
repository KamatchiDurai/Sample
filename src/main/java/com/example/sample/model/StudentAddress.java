package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StudentAddress implements Serializable {


    public int studentNumber;

    public Address address;

    public StudentAddress() {
    }

    public StudentAddress(int studentNumber, Address address) {
        this.studentNumber = studentNumber;
        this.address = address;
    }


}

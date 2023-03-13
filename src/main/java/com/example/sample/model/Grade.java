package com.example.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Grade implements Serializable {

    @SerializedName("subject")
    public String subject;

    @SerializedName("grade")
    public String grade;

    public Grade(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public Grade() {
    }
}

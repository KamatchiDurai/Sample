package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("role")
    public String role;

    @SerializedName("authToken")
    public String authToken;

    public Users(String role, String authToken) {
        this.role = role;
        this.authToken = authToken;
    }

    public Users() {

    }
}

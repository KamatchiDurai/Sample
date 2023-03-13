package com.example.sample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable {

    @SerializedName("streetNumber")
    public String streetNumber;

    @SerializedName("street")
    public String street;

    @SerializedName("city")
    public String city;

    @SerializedName("province")
    public String province;

   public Address() {

   }

    public Address(String streetNumber, String street, String city, String province) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.province = province;
    }
}

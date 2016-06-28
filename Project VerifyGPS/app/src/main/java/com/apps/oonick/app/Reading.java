package com.apps.oonick.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by N. Shayan on 10-6-2016.
 */
public class Reading {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("device")
    @Expose
    private String device;

    @SerializedName("location")
    @Expose
    private List<String> location;

    @SerializedName("temperature")
    @Expose
    private float temperature;

    @SerializedName("user")
    @Expose
    private String user;

    public Reading(String id, String date, String device, List<String> location, float temperature, String user) {

        this.id = id;
        this.date = date;
        this.device = device;
        this.location = location;
        this.temperature = temperature;
        this.user = user;
    }

    public Reading(String date, String device, List<String> location, float temperature, String user) {
        this.date = date;
        this.device = device;
        this.location = location;
        this.temperature = temperature;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reading " +
                "'" + id + '\'' +
                " was recorded on " + date +
                " on device '" + device + '\'' +
                " at location " + location +
                " with temperature reaching " + temperature +
                " by user " + user;
    }

}
package com.example.dietapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
// table for saturday
@Entity(tableName = "dietplan_saturday")
public class DietPlanDataSaturday implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name= "breakfastName")
    private String breakfastName;

    @ColumnInfo(name = "breakfastCalories")
    private  String breakfastCaloriers;

    @ColumnInfo(name = "brunchName")
    private  String brunchName;

    @ColumnInfo(name = "brunchCalories")
    private  String brunchCal;

    @ColumnInfo(name = "lunchName")
    private  String lunchName;

    @ColumnInfo(name = "lunchCalories")
    private  String lunchCal;

    @ColumnInfo(name = "teaName")
    private  String teaName;

    @ColumnInfo(name ="teaCalories")
    private  String teaCal;

    @ColumnInfo(name = "dinnerName")
    private  String dinnerName;

    @ColumnInfo(name = "dinnerCalories")
    private  String dinnerCal;

    @ColumnInfo(name = "createdAt", defaultValue = "CURRENT_TIMESTAMP")
    private String createdAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public String getBreakfastCaloriers() {
        return breakfastCaloriers;
    }

    public void setBreakfastCaloriers(String breakfastCaloriers) {
        this.breakfastCaloriers = breakfastCaloriers;
    }

    public String getBrunchName() {
        return brunchName;
    }

    public void setBrunchName(String brunchName) {
        this.brunchName = brunchName;
    }

    public String getBrunchCal() {
        return brunchCal;
    }

    public void setBrunchCal(String brunchCal) {
        this.brunchCal = brunchCal;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public String getLunchCal() {
        return lunchCal;
    }

    public void setLunchCal(String lunchCal) {
        this.lunchCal = lunchCal;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaCal() {
        return teaCal;
    }

    public void setTeaCal(String teaCal) {
        this.teaCal = teaCal;
    }

    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public String getDinnerCal() {
        return dinnerCal;
    }

    public void setDinnerCal(String dinnerCal) {
        this.dinnerCal = dinnerCal;
    }
}
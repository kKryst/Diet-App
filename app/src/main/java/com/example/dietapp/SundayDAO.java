package com.example.dietapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SundayDAO {

    // EVERYTHING OPERATING-ON-DATABASE RELATED
    @Insert(onConflict = REPLACE)
    void insert(DietPlanDataSunday dietplansunday);

    @Delete
    void delete(DietPlanDataSunday dietplansunday);

    @Delete
    void reset(List<DietPlanDataSunday> dietPlanDatumsunday);


    @Query("UPDATE dietplan_sunday SET breakfastName = :sbreakfastName," +
            "breakfastCalories = :sbreakfastCalories," +
            "brunchName = :sbrunchName," +
            "brunchCalories = :sbrunchCalories," +
            "lunchName = :slunchName," +
            "lunchCalories = :slunchCalories," +
            "teaName = :steaName," +
            "teaCalories = :steaCalories," +
            "dinnerName = :sdinnerName," +
            "dinnerCalories=:sdinnerCalories," +
            "createdAt =:screatedAt WHERE ID = :sID")
    void updateAll(int sID, String sbreakfastName,
                   String sbreakfastCalories,
                   String sbrunchName,
                   String sbrunchCalories,
                   String slunchName,
                   String slunchCalories,
                   String steaName,
                   String steaCalories,
                   String sdinnerName,
                   String sdinnerCalories,
                   String screatedAt);

    @Query("UPDATE dietplan_sunday SET breakfastName = :sValue WHERE createdAt = :sDate")
    void updateBreakfastName(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET breakfastCalories = :sValue WHERE createdAt = :sDate")
    void updateBreakfastCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET brunchName = :sValue WHERE createdAt = :sDate")
    void updateBrunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET brunchCalories = :sValue WHERE createdAt = :sDate")
    void updateBrunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET lunchName = :sValue WHERE createdAt = :sDate")
    void updateLunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET lunchCalories = :sValue WHERE createdAt = :sDate")
    void updateLunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET teaName = :sValue WHERE createdAt = :sDate")
    void updateTeaName(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET teaCalories = :sValue WHERE createdAt = :sDate")
    void updateTeaCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET dinnerName = :sValue WHERE createdAt = :sDate")
    void updateDinnerName(String sValue, String sDate);

    @Query("UPDATE dietplan_sunday SET dinnerCalories = :sValue WHERE createdAt = :sDate")
    void updateDinnerCalories(String sValue, String sDate);



    @Query("SELECT * FROM dietplan_sunday")
    List<DietPlanDataSunday> getAll();
    @Query("SELECT breakfastName FROM dietplan_sunday WHERE createdAt = :sDate")
    String breakfastNameFinder(String sDate);

    @Query("SELECT breakfastCalories FROM dietplan_sunday WHERE createdAt = :sDate")
    String breakfastCaloriesFinder(String sDate);

    @Query("SELECT brunchName FROM dietplan_sunday WHERE createdAt = :sDate")
    String brunchNameFinder(String sDate);

    @Query("SELECT brunchCalories FROM dietplan_sunday WHERE createdAt = :sDate")
    String brunchCaloriesFinder(String sDate);

    @Query("SELECT lunchName FROM dietplan_sunday WHERE createdAt = :sDate")
    String lunchNameFinder(String sDate);

    @Query("SELECT lunchCalories FROM dietplan_sunday WHERE createdAt = :sDate")
    String lunchCaloriesFinder(String sDate);

    @Query("SELECT teaName FROM dietplan_sunday WHERE createdAt = :sDate")
    String teaNameFinder(String sDate);

    @Query("SELECT teaCalories FROM dietplan_sunday WHERE createdAt = :sDate")
    String teaCaloriesFinder(String sDate);

    @Query("SELECT dinnerName FROM dietplan_sunday WHERE createdAt = :sDate")
    String dinnerNameFinder(String sDate);

    @Query("SELECT dinnerCalories FROM dietplan_sunday WHERE createdAt = :sDate")
    String dinnerCaloriesFinder(String sDate);

    @Query("SELECT createdAt FROM dietplan_sunday WHERE createdAt = :currentDate")
    boolean checkIfGivenDataEntryExists(String currentDate);
}
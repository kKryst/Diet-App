package com.example.dietapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WednesdayDAO {

    // EVERYTHING OPERATING-ON-DATABASE RELATED
    @Insert(onConflict = REPLACE)
    void insert(DietPlanDataWednesday dietplantuesday);

    @Delete
    void delete(DietPlanDataWednesday dietplantuesday);

    @Delete
    void reset(List<DietPlanDataWednesday> dietPlanDatumTuesday);


    @Query("UPDATE dietplan_wednesday SET breakfastName = :sbreakfastName," +
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

    @Query("UPDATE dietplan_wednesday SET breakfastName = :sValue WHERE createdAt = :sDate")
    void updateBreakfastName(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET breakfastCalories = :sValue WHERE createdAt = :sDate")
    void updateBreakfastCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET brunchName = :sValue WHERE createdAt = :sDate")
    void updateBrunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET brunchCalories = :sValue WHERE createdAt = :sDate")
    void updateBrunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET lunchName = :sValue WHERE createdAt = :sDate")
    void updateLunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET lunchCalories = :sValue WHERE createdAt = :sDate")
    void updateLunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET teaName = :sValue WHERE createdAt = :sDate")
    void updateTeaName(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET teaCalories = :sValue WHERE createdAt = :sDate")
    void updateTeaCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET dinnerName = :sValue WHERE createdAt = :sDate")
    void updateDinnerName(String sValue, String sDate);

    @Query("UPDATE dietplan_wednesday SET dinnerCalories = :sValue WHERE createdAt = :sDate")
    void updateDinnerCalories(String sValue, String sDate);



    @Query("SELECT * FROM dietplan_wednesday")
    List<DietPlanDataWednesday> getAll();
    @Query("SELECT breakfastName FROM dietplan_wednesday WHERE createdAt = :sDate")
    String breakfastNameFinder(String sDate);

    @Query("SELECT breakfastCalories FROM dietplan_wednesday WHERE createdAt = :sDate")
    String breakfastCaloriesFinder(String sDate);

    @Query("SELECT brunchName FROM dietplan_wednesday WHERE createdAt = :sDate")
    String brunchNameFinder(String sDate);

    @Query("SELECT brunchCalories FROM dietplan_wednesday WHERE createdAt = :sDate")
    String brunchCaloriesFinder(String sDate);

    @Query("SELECT lunchName FROM dietplan_wednesday WHERE createdAt = :sDate")
    String lunchNameFinder(String sDate);

    @Query("SELECT lunchCalories FROM dietplan_wednesday WHERE createdAt = :sDate")
    String lunchCaloriesFinder(String sDate);

    @Query("SELECT teaName FROM dietplan_wednesday WHERE createdAt = :sDate")
    String teaNameFinder(String sDate);

    @Query("SELECT teaCalories FROM dietplan_wednesday WHERE createdAt = :sDate")
    String teaCaloriesFinder(String sDate);

    @Query("SELECT dinnerName FROM dietplan_wednesday WHERE createdAt = :sDate")
    String dinnerNameFinder(String sDate);

    @Query("SELECT dinnerCalories FROM dietplan_wednesday WHERE createdAt = :sDate")
    String dinnerCaloriesFinder(String sDate);

    @Query("SELECT createdAt FROM dietplan_wednesday WHERE createdAt = :currentDate")
    boolean checkIfGivenDataEntryExists(String currentDate);
}
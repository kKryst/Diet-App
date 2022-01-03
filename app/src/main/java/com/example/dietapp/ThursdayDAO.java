package com.example.dietapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ThursdayDAO {

    // EVERYTHING OPERATING-ON-DATABASE RELATED
    @Insert(onConflict = REPLACE)
    void insert(DietPlanDataThursday dietplanthursday);

    @Delete
    void delete(DietPlanDataThursday dietplanthursday);

    @Delete
    void reset(List<DietPlanDataThursday> dietPlanDatumthursday);


    @Query("UPDATE dietplan_thursday SET breakfastName = :sbreakfastName," +
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

    @Query("UPDATE dietplan_thursday SET breakfastName = :sValue WHERE createdAt = :sDate")
    void updateBreakfastName(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET breakfastCalories = :sValue WHERE createdAt = :sDate")
    void updateBreakfastCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET brunchName = :sValue WHERE createdAt = :sDate")
    void updateBrunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET brunchCalories = :sValue WHERE createdAt = :sDate")
    void updateBrunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET lunchName = :sValue WHERE createdAt = :sDate")
    void updateLunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET lunchCalories = :sValue WHERE createdAt = :sDate")
    void updateLunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET teaName = :sValue WHERE createdAt = :sDate")
    void updateTeaName(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET teaCalories = :sValue WHERE createdAt = :sDate")
    void updateTeaCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET dinnerName = :sValue WHERE createdAt = :sDate")
    void updateDinnerName(String sValue, String sDate);

    @Query("UPDATE dietplan_thursday SET dinnerCalories = :sValue WHERE createdAt = :sDate")
    void updateDinnerCalories(String sValue, String sDate);



    @Query("SELECT * FROM dietplan_thursday")
    List<DietPlanDataThursday> getAll();
    @Query("SELECT breakfastName FROM dietplan_thursday WHERE createdAt = :sDate")
    String breakfastNameFinder(String sDate);

    @Query("SELECT breakfastCalories FROM dietplan_thursday WHERE createdAt = :sDate")
    String breakfastCaloriesFinder(String sDate);

    @Query("SELECT brunchName FROM dietplan_thursday WHERE createdAt = :sDate")
    String brunchNameFinder(String sDate);

    @Query("SELECT brunchCalories FROM dietplan_thursday WHERE createdAt = :sDate")
    String brunchCaloriesFinder(String sDate);

    @Query("SELECT lunchName FROM dietplan_thursday WHERE createdAt = :sDate")
    String lunchNameFinder(String sDate);

    @Query("SELECT lunchCalories FROM dietplan_thursday WHERE createdAt = :sDate")
    String lunchCaloriesFinder(String sDate);

    @Query("SELECT teaName FROM dietplan_thursday WHERE createdAt = :sDate")
    String teaNameFinder(String sDate);

    @Query("SELECT teaCalories FROM dietplan_thursday WHERE createdAt = :sDate")
    String teaCaloriesFinder(String sDate);

    @Query("SELECT dinnerName FROM dietplan_thursday WHERE createdAt = :sDate")
    String dinnerNameFinder(String sDate);

    @Query("SELECT dinnerCalories FROM dietplan_thursday WHERE createdAt = :sDate")
    String dinnerCaloriesFinder(String sDate);

    @Query("SELECT createdAt FROM dietplan_thursday WHERE createdAt = :currentDate")
    boolean checkIfGivenDataEntryExists(String currentDate);
}
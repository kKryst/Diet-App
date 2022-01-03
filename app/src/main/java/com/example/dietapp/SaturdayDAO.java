package com.example.dietapp;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SaturdayDAO {

    // EVERYTHING OPERATING-ON-DATABASE RELATED
    @Insert(onConflict = REPLACE)
    void insert(DietPlanDataSaturday dietplansaturday);

    @Delete
    void delete(DietPlanDataSaturday dietplansaturday);

    @Delete
    void reset(List<DietPlanDataSaturday> dietPlanDatumsaturday);


    @Query("UPDATE dietplan_saturday SET breakfastName = :sbreakfastName," +
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

    @Query("UPDATE dietplan_saturday SET breakfastName = :sValue WHERE createdAt = :sDate")
    void updateBreakfastName(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET breakfastCalories = :sValue WHERE createdAt = :sDate")
    void updateBreakfastCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET brunchName = :sValue WHERE createdAt = :sDate")
    void updateBrunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET brunchCalories = :sValue WHERE createdAt = :sDate")
    void updateBrunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET lunchName = :sValue WHERE createdAt = :sDate")
    void updateLunchName(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET lunchCalories = :sValue WHERE createdAt = :sDate")
    void updateLunchCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET teaName = :sValue WHERE createdAt = :sDate")
    void updateTeaName(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET teaCalories = :sValue WHERE createdAt = :sDate")
    void updateTeaCalories(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET dinnerName = :sValue WHERE createdAt = :sDate")
    void updateDinnerName(String sValue, String sDate);

    @Query("UPDATE dietplan_saturday SET dinnerCalories = :sValue WHERE createdAt = :sDate")
    void updateDinnerCalories(String sValue, String sDate);



    @Query("SELECT * FROM dietplan_saturday")
    List<DietPlanDataSaturday> getAll();
    @Query("SELECT breakfastName FROM dietplan_saturday WHERE createdAt = :sDate")
    String breakfastNameFinder(String sDate);

    @Query("SELECT breakfastCalories FROM dietplan_saturday WHERE createdAt = :sDate")
    String breakfastCaloriesFinder(String sDate);

    @Query("SELECT brunchName FROM dietplan_saturday WHERE createdAt = :sDate")
    String brunchNameFinder(String sDate);

    @Query("SELECT brunchCalories FROM dietplan_saturday WHERE createdAt = :sDate")
    String brunchCaloriesFinder(String sDate);

    @Query("SELECT lunchName FROM dietplan_saturday WHERE createdAt = :sDate")
    String lunchNameFinder(String sDate);

    @Query("SELECT lunchCalories FROM dietplan_saturday WHERE createdAt = :sDate")
    String lunchCaloriesFinder(String sDate);

    @Query("SELECT teaName FROM dietplan_saturday WHERE createdAt = :sDate")
    String teaNameFinder(String sDate);

    @Query("SELECT teaCalories FROM dietplan_saturday WHERE createdAt = :sDate")
    String teaCaloriesFinder(String sDate);

    @Query("SELECT dinnerName FROM dietplan_saturday WHERE createdAt = :sDate")
    String dinnerNameFinder(String sDate);

    @Query("SELECT dinnerCalories FROM dietplan_saturday WHERE createdAt = :sDate")
    String dinnerCaloriesFinder(String sDate);

    @Query("SELECT createdAt FROM dietplan_saturday WHERE createdAt = :currentDate")
    boolean checkIfGivenDataEntryExists(String currentDate);
}
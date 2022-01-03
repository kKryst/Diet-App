package com.example.dietapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {DietPlanDataMonday.class, DietPlanDataTuesday.class, DietPlanDataWednesday.class, DietPlanDataThursday.class,
DietPlanDataFriday.class, DietPlanDataSaturday.class, DietPlanDataSunday.class}, version = 7, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    // tworzy instancje bazy danych
    private static RoomDB database;
    // definiuje nazwe bazy danych
    private static final String DATABASE_NAME = "dietplan_data";

    public synchronized static RoomDB getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
            RoomDB.class, DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build();
        }
        return database;
    }
    public abstract MondayDAO mondayDAO();
    public abstract TuesdayDAO tuesdayDAO();
    public abstract WednesdayDAO wednesdayDAO();
    public abstract ThursdayDAO thursdayDAO();
    public abstract FridayDAO fridayDAO();
    public abstract SaturdayDAO saturdayDAO();
    public abstract SundayDAO sundayDAO();
}

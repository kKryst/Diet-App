package com.example.dietapp;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDB_Impl extends RoomDB {
  private volatile MondayDAO _mondayDAO;

  private volatile TuesdayDAO _tuesdayDAO;

  private volatile WednesdayDAO _wednesdayDAO;

  private volatile ThursdayDAO _thursdayDAO;

  private volatile FridayDAO _fridayDAO;

  private volatile SaturdayDAO _saturdayDAO;

  private volatile SundayDAO _sundayDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(7) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_data` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_tuesday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_wednesday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_thursday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_friday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_saturday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dietplan_sunday` (`ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfastName` TEXT, `breakfastCalories` TEXT, `brunchName` TEXT, `brunchCalories` TEXT, `lunchName` TEXT, `lunchCalories` TEXT, `teaName` TEXT, `teaCalories` TEXT, `dinnerName` TEXT, `dinnerCalories` TEXT, `createdAt` TEXT DEFAULT CURRENT_TIMESTAMP)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ffdadb5d9933856b669e4da7f4ebc258')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_data`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_tuesday`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_wednesday`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_thursday`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_friday`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_saturday`");
        _db.execSQL("DROP TABLE IF EXISTS `dietplan_sunday`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDietplanData = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanData.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanData.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanData = new TableInfo("dietplan_data", _columnsDietplanData, _foreignKeysDietplanData, _indicesDietplanData);
        final TableInfo _existingDietplanData = TableInfo.read(_db, "dietplan_data");
        if (! _infoDietplanData.equals(_existingDietplanData)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_data(com.example.dietapp.DietPlanDataMonday).\n"
                  + " Expected:\n" + _infoDietplanData + "\n"
                  + " Found:\n" + _existingDietplanData);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanTuesday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanTuesday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanTuesday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanTuesday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanTuesday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanTuesday = new TableInfo("dietplan_tuesday", _columnsDietplanTuesday, _foreignKeysDietplanTuesday, _indicesDietplanTuesday);
        final TableInfo _existingDietplanTuesday = TableInfo.read(_db, "dietplan_tuesday");
        if (! _infoDietplanTuesday.equals(_existingDietplanTuesday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_tuesday(com.example.dietapp.DietPlanDataTuesday).\n"
                  + " Expected:\n" + _infoDietplanTuesday + "\n"
                  + " Found:\n" + _existingDietplanTuesday);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanWednesday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanWednesday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanWednesday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanWednesday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanWednesday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanWednesday = new TableInfo("dietplan_wednesday", _columnsDietplanWednesday, _foreignKeysDietplanWednesday, _indicesDietplanWednesday);
        final TableInfo _existingDietplanWednesday = TableInfo.read(_db, "dietplan_wednesday");
        if (! _infoDietplanWednesday.equals(_existingDietplanWednesday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_wednesday(com.example.dietapp.DietPlanDataWednesday).\n"
                  + " Expected:\n" + _infoDietplanWednesday + "\n"
                  + " Found:\n" + _existingDietplanWednesday);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanThursday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanThursday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanThursday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanThursday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanThursday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanThursday = new TableInfo("dietplan_thursday", _columnsDietplanThursday, _foreignKeysDietplanThursday, _indicesDietplanThursday);
        final TableInfo _existingDietplanThursday = TableInfo.read(_db, "dietplan_thursday");
        if (! _infoDietplanThursday.equals(_existingDietplanThursday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_thursday(com.example.dietapp.DietPlanDataThursday).\n"
                  + " Expected:\n" + _infoDietplanThursday + "\n"
                  + " Found:\n" + _existingDietplanThursday);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanFriday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanFriday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanFriday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanFriday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanFriday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanFriday = new TableInfo("dietplan_friday", _columnsDietplanFriday, _foreignKeysDietplanFriday, _indicesDietplanFriday);
        final TableInfo _existingDietplanFriday = TableInfo.read(_db, "dietplan_friday");
        if (! _infoDietplanFriday.equals(_existingDietplanFriday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_friday(com.example.dietapp.DietPlanDataFriday).\n"
                  + " Expected:\n" + _infoDietplanFriday + "\n"
                  + " Found:\n" + _existingDietplanFriday);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanSaturday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanSaturday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSaturday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanSaturday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanSaturday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanSaturday = new TableInfo("dietplan_saturday", _columnsDietplanSaturday, _foreignKeysDietplanSaturday, _indicesDietplanSaturday);
        final TableInfo _existingDietplanSaturday = TableInfo.read(_db, "dietplan_saturday");
        if (! _infoDietplanSaturday.equals(_existingDietplanSaturday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_saturday(com.example.dietapp.DietPlanDataSaturday).\n"
                  + " Expected:\n" + _infoDietplanSaturday + "\n"
                  + " Found:\n" + _existingDietplanSaturday);
        }
        final HashMap<String, TableInfo.Column> _columnsDietplanSunday = new HashMap<String, TableInfo.Column>(12);
        _columnsDietplanSunday.put("ID", new TableInfo.Column("ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("breakfastName", new TableInfo.Column("breakfastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("breakfastCalories", new TableInfo.Column("breakfastCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("brunchName", new TableInfo.Column("brunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("brunchCalories", new TableInfo.Column("brunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("lunchName", new TableInfo.Column("lunchName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("lunchCalories", new TableInfo.Column("lunchCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("teaName", new TableInfo.Column("teaName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("teaCalories", new TableInfo.Column("teaCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("dinnerName", new TableInfo.Column("dinnerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("dinnerCalories", new TableInfo.Column("dinnerCalories", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDietplanSunday.put("createdAt", new TableInfo.Column("createdAt", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDietplanSunday = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDietplanSunday = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDietplanSunday = new TableInfo("dietplan_sunday", _columnsDietplanSunday, _foreignKeysDietplanSunday, _indicesDietplanSunday);
        final TableInfo _existingDietplanSunday = TableInfo.read(_db, "dietplan_sunday");
        if (! _infoDietplanSunday.equals(_existingDietplanSunday)) {
          return new RoomOpenHelper.ValidationResult(false, "dietplan_sunday(com.example.dietapp.DietPlanDataSunday).\n"
                  + " Expected:\n" + _infoDietplanSunday + "\n"
                  + " Found:\n" + _existingDietplanSunday);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ffdadb5d9933856b669e4da7f4ebc258", "aec848d07c0b50ad9726660a8723176c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "dietplan_data","dietplan_tuesday","dietplan_wednesday","dietplan_thursday","dietplan_friday","dietplan_saturday","dietplan_sunday");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `dietplan_data`");
      _db.execSQL("DELETE FROM `dietplan_tuesday`");
      _db.execSQL("DELETE FROM `dietplan_wednesday`");
      _db.execSQL("DELETE FROM `dietplan_thursday`");
      _db.execSQL("DELETE FROM `dietplan_friday`");
      _db.execSQL("DELETE FROM `dietplan_saturday`");
      _db.execSQL("DELETE FROM `dietplan_sunday`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MondayDAO.class, MondayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(TuesdayDAO.class, TuesdayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(WednesdayDAO.class, WednesdayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ThursdayDAO.class, ThursdayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(FridayDAO.class, FridayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(SaturdayDAO.class, SaturdayDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(SundayDAO.class, SundayDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public MondayDAO mondayDAO() {
    if (_mondayDAO != null) {
      return _mondayDAO;
    } else {
      synchronized(this) {
        if(_mondayDAO == null) {
          _mondayDAO = new MondayDAO_Impl(this);
        }
        return _mondayDAO;
      }
    }
  }

  @Override
  public TuesdayDAO tuesdayDAO() {
    if (_tuesdayDAO != null) {
      return _tuesdayDAO;
    } else {
      synchronized(this) {
        if(_tuesdayDAO == null) {
          _tuesdayDAO = new TuesdayDAO_Impl(this);
        }
        return _tuesdayDAO;
      }
    }
  }

  @Override
  public WednesdayDAO wednesdayDAO() {
    if (_wednesdayDAO != null) {
      return _wednesdayDAO;
    } else {
      synchronized(this) {
        if(_wednesdayDAO == null) {
          _wednesdayDAO = new WednesdayDAO_Impl(this);
        }
        return _wednesdayDAO;
      }
    }
  }

  @Override
  public ThursdayDAO thursdayDAO() {
    if (_thursdayDAO != null) {
      return _thursdayDAO;
    } else {
      synchronized(this) {
        if(_thursdayDAO == null) {
          _thursdayDAO = new ThursdayDAO_Impl(this);
        }
        return _thursdayDAO;
      }
    }
  }

  @Override
  public FridayDAO fridayDAO() {
    if (_fridayDAO != null) {
      return _fridayDAO;
    } else {
      synchronized(this) {
        if(_fridayDAO == null) {
          _fridayDAO = new FridayDAO_Impl(this);
        }
        return _fridayDAO;
      }
    }
  }

  @Override
  public SaturdayDAO saturdayDAO() {
    if (_saturdayDAO != null) {
      return _saturdayDAO;
    } else {
      synchronized(this) {
        if(_saturdayDAO == null) {
          _saturdayDAO = new SaturdayDAO_Impl(this);
        }
        return _saturdayDAO;
      }
    }
  }

  @Override
  public SundayDAO sundayDAO() {
    if (_sundayDAO != null) {
      return _sundayDAO;
    } else {
      synchronized(this) {
        if(_sundayDAO == null) {
          _sundayDAO = new SundayDAO_Impl(this);
        }
        return _sundayDAO;
      }
    }
  }
}

package com.example.dietapp;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ThursdayDAO_Impl implements ThursdayDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DietPlanDataThursday> __insertionAdapterOfDietPlanDataThursday;

  private final EntityDeletionOrUpdateAdapter<DietPlanDataThursday> __deletionAdapterOfDietPlanDataThursday;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBreakfastName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBreakfastCalories;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBrunchName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBrunchCalories;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLunchName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLunchCalories;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTeaName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTeaCalories;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDinnerName;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDinnerCalories;

  public ThursdayDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDietPlanDataThursday = new EntityInsertionAdapter<DietPlanDataThursday>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `dietplan_thursday` (`ID`,`breakfastName`,`breakfastCalories`,`brunchName`,`brunchCalories`,`lunchName`,`lunchCalories`,`teaName`,`teaCalories`,`dinnerName`,`dinnerCalories`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DietPlanDataThursday value) {
        stmt.bindLong(1, value.getID());
        if (value.getBreakfastName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBreakfastName());
        }
        if (value.getBreakfastCaloriers() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBreakfastCaloriers());
        }
        if (value.getBrunchName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBrunchName());
        }
        if (value.getBrunchCal() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBrunchCal());
        }
        if (value.getLunchName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLunchName());
        }
        if (value.getLunchCal() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLunchCal());
        }
        if (value.getTeaName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTeaName());
        }
        if (value.getTeaCal() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTeaCal());
        }
        if (value.getDinnerName() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDinnerName());
        }
        if (value.getDinnerCal() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDinnerCal());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatedAt());
        }
      }
    };
    this.__deletionAdapterOfDietPlanDataThursday = new EntityDeletionOrUpdateAdapter<DietPlanDataThursday>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `dietplan_thursday` WHERE `ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DietPlanDataThursday value) {
        stmt.bindLong(1, value.getID());
      }
    };
    this.__preparedStmtOfUpdateAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET breakfastName = ?,breakfastCalories = ?,brunchName = ?,brunchCalories = ?,lunchName = ?,lunchCalories = ?,teaName = ?,teaCalories = ?,dinnerName = ?,dinnerCalories=?,createdAt =? WHERE ID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBreakfastName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET breakfastName = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBreakfastCalories = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET breakfastCalories = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBrunchName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET brunchName = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBrunchCalories = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET brunchCalories = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLunchName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET lunchName = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLunchCalories = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET lunchCalories = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTeaName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET teaName = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTeaCalories = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET teaCalories = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDinnerName = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET dinnerName = ? WHERE createdAt = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDinnerCalories = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE dietplan_thursday SET dinnerCalories = ? WHERE createdAt = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final DietPlanDataThursday dietplanthursday) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDietPlanDataThursday.insert(dietplanthursday);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final DietPlanDataThursday dietplanthursday) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDietPlanDataThursday.handle(dietplanthursday);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void reset(final List<DietPlanDataThursday> dietPlanDatumthursday) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDietPlanDataThursday.handleMultiple(dietPlanDatumthursday);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAll(final int sID, final String sbreakfastName, final String sbreakfastCalories,
      final String sbrunchName, final String sbrunchCalories, final String slunchName,
      final String slunchCalories, final String steaName, final String steaCalories,
      final String sdinnerName, final String sdinnerCalories, final String screatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAll.acquire();
    int _argIndex = 1;
    if (sbreakfastName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sbreakfastName);
    }
    _argIndex = 2;
    if (sbreakfastCalories == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sbreakfastCalories);
    }
    _argIndex = 3;
    if (sbrunchName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sbrunchName);
    }
    _argIndex = 4;
    if (sbrunchCalories == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sbrunchCalories);
    }
    _argIndex = 5;
    if (slunchName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, slunchName);
    }
    _argIndex = 6;
    if (slunchCalories == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, slunchCalories);
    }
    _argIndex = 7;
    if (steaName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, steaName);
    }
    _argIndex = 8;
    if (steaCalories == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, steaCalories);
    }
    _argIndex = 9;
    if (sdinnerName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sdinnerName);
    }
    _argIndex = 10;
    if (sdinnerCalories == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sdinnerCalories);
    }
    _argIndex = 11;
    if (screatedAt == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, screatedAt);
    }
    _argIndex = 12;
    _stmt.bindLong(_argIndex, sID);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAll.release(_stmt);
    }
  }

  @Override
  public void updateBreakfastName(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBreakfastName.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBreakfastName.release(_stmt);
    }
  }

  @Override
  public void updateBreakfastCalories(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBreakfastCalories.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBreakfastCalories.release(_stmt);
    }
  }

  @Override
  public void updateBrunchName(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBrunchName.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBrunchName.release(_stmt);
    }
  }

  @Override
  public void updateBrunchCalories(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBrunchCalories.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBrunchCalories.release(_stmt);
    }
  }

  @Override
  public void updateLunchName(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLunchName.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateLunchName.release(_stmt);
    }
  }

  @Override
  public void updateLunchCalories(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLunchCalories.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateLunchCalories.release(_stmt);
    }
  }

  @Override
  public void updateTeaName(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTeaName.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTeaName.release(_stmt);
    }
  }

  @Override
  public void updateTeaCalories(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTeaCalories.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTeaCalories.release(_stmt);
    }
  }

  @Override
  public void updateDinnerName(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDinnerName.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDinnerName.release(_stmt);
    }
  }

  @Override
  public void updateDinnerCalories(final String sValue, final String sDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDinnerCalories.acquire();
    int _argIndex = 1;
    if (sValue == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sValue);
    }
    _argIndex = 2;
    if (sDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDinnerCalories.release(_stmt);
    }
  }

  @Override
  public List<DietPlanDataThursday> getAll() {
    final String _sql = "SELECT * FROM dietplan_thursday";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
      final int _cursorIndexOfBreakfastName = CursorUtil.getColumnIndexOrThrow(_cursor, "breakfastName");
      final int _cursorIndexOfBreakfastCaloriers = CursorUtil.getColumnIndexOrThrow(_cursor, "breakfastCalories");
      final int _cursorIndexOfBrunchName = CursorUtil.getColumnIndexOrThrow(_cursor, "brunchName");
      final int _cursorIndexOfBrunchCal = CursorUtil.getColumnIndexOrThrow(_cursor, "brunchCalories");
      final int _cursorIndexOfLunchName = CursorUtil.getColumnIndexOrThrow(_cursor, "lunchName");
      final int _cursorIndexOfLunchCal = CursorUtil.getColumnIndexOrThrow(_cursor, "lunchCalories");
      final int _cursorIndexOfTeaName = CursorUtil.getColumnIndexOrThrow(_cursor, "teaName");
      final int _cursorIndexOfTeaCal = CursorUtil.getColumnIndexOrThrow(_cursor, "teaCalories");
      final int _cursorIndexOfDinnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "dinnerName");
      final int _cursorIndexOfDinnerCal = CursorUtil.getColumnIndexOrThrow(_cursor, "dinnerCalories");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final List<DietPlanDataThursday> _result = new ArrayList<DietPlanDataThursday>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DietPlanDataThursday _item;
        _item = new DietPlanDataThursday();
        final int _tmpID;
        _tmpID = _cursor.getInt(_cursorIndexOfID);
        _item.setID(_tmpID);
        final String _tmpBreakfastName;
        if (_cursor.isNull(_cursorIndexOfBreakfastName)) {
          _tmpBreakfastName = null;
        } else {
          _tmpBreakfastName = _cursor.getString(_cursorIndexOfBreakfastName);
        }
        _item.setBreakfastName(_tmpBreakfastName);
        final String _tmpBreakfastCaloriers;
        if (_cursor.isNull(_cursorIndexOfBreakfastCaloriers)) {
          _tmpBreakfastCaloriers = null;
        } else {
          _tmpBreakfastCaloriers = _cursor.getString(_cursorIndexOfBreakfastCaloriers);
        }
        _item.setBreakfastCaloriers(_tmpBreakfastCaloriers);
        final String _tmpBrunchName;
        if (_cursor.isNull(_cursorIndexOfBrunchName)) {
          _tmpBrunchName = null;
        } else {
          _tmpBrunchName = _cursor.getString(_cursorIndexOfBrunchName);
        }
        _item.setBrunchName(_tmpBrunchName);
        final String _tmpBrunchCal;
        if (_cursor.isNull(_cursorIndexOfBrunchCal)) {
          _tmpBrunchCal = null;
        } else {
          _tmpBrunchCal = _cursor.getString(_cursorIndexOfBrunchCal);
        }
        _item.setBrunchCal(_tmpBrunchCal);
        final String _tmpLunchName;
        if (_cursor.isNull(_cursorIndexOfLunchName)) {
          _tmpLunchName = null;
        } else {
          _tmpLunchName = _cursor.getString(_cursorIndexOfLunchName);
        }
        _item.setLunchName(_tmpLunchName);
        final String _tmpLunchCal;
        if (_cursor.isNull(_cursorIndexOfLunchCal)) {
          _tmpLunchCal = null;
        } else {
          _tmpLunchCal = _cursor.getString(_cursorIndexOfLunchCal);
        }
        _item.setLunchCal(_tmpLunchCal);
        final String _tmpTeaName;
        if (_cursor.isNull(_cursorIndexOfTeaName)) {
          _tmpTeaName = null;
        } else {
          _tmpTeaName = _cursor.getString(_cursorIndexOfTeaName);
        }
        _item.setTeaName(_tmpTeaName);
        final String _tmpTeaCal;
        if (_cursor.isNull(_cursorIndexOfTeaCal)) {
          _tmpTeaCal = null;
        } else {
          _tmpTeaCal = _cursor.getString(_cursorIndexOfTeaCal);
        }
        _item.setTeaCal(_tmpTeaCal);
        final String _tmpDinnerName;
        if (_cursor.isNull(_cursorIndexOfDinnerName)) {
          _tmpDinnerName = null;
        } else {
          _tmpDinnerName = _cursor.getString(_cursorIndexOfDinnerName);
        }
        _item.setDinnerName(_tmpDinnerName);
        final String _tmpDinnerCal;
        if (_cursor.isNull(_cursorIndexOfDinnerCal)) {
          _tmpDinnerCal = null;
        } else {
          _tmpDinnerCal = _cursor.getString(_cursorIndexOfDinnerCal);
        }
        _item.setDinnerCal(_tmpDinnerCal);
        final String _tmpCreatedAt;
        if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
          _tmpCreatedAt = null;
        } else {
          _tmpCreatedAt = _cursor.getString(_cursorIndexOfCreatedAt);
        }
        _item.setCreatedAt(_tmpCreatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String breakfastNameFinder(final String sDate) {
    final String _sql = "SELECT breakfastName FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String breakfastCaloriesFinder(final String sDate) {
    final String _sql = "SELECT breakfastCalories FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String brunchNameFinder(final String sDate) {
    final String _sql = "SELECT brunchName FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String brunchCaloriesFinder(final String sDate) {
    final String _sql = "SELECT brunchCalories FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String lunchNameFinder(final String sDate) {
    final String _sql = "SELECT lunchName FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String lunchCaloriesFinder(final String sDate) {
    final String _sql = "SELECT lunchCalories FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String teaNameFinder(final String sDate) {
    final String _sql = "SELECT teaName FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String teaCaloriesFinder(final String sDate) {
    final String _sql = "SELECT teaCalories FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String dinnerNameFinder(final String sDate) {
    final String _sql = "SELECT dinnerName FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String dinnerCaloriesFinder(final String sDate) {
    final String _sql = "SELECT dinnerCalories FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean checkIfGivenDataEntryExists(final String currentDate) {
    final String _sql = "SELECT createdAt FROM dietplan_thursday WHERE createdAt = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (currentDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

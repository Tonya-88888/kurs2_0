package com.example.kurs2_0;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "habits.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "habit"; // название таблицы в бд

    // названия столбцов
    public static final String HABIT_ID = "_id";
    public static final String HABIT_NAME = "name";
    public static final String HABIT_NOTIFICATION = "notification";
    public static final String HABIT_TIME = "time";
    public static final String HABIT_DAY = "day";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE  +" (" + HABIT_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + HABIT_NAME
                + " TEXT, " + HABIT_NOTIFICATION + " TEXT, "+HABIT_TIME +" TEXT, "+HABIT_DAY+" INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
                onCreate(sqLiteDatabase);
    }


    boolean  InsertDate(Context ctx, String name, String notification, long time, int day){
        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(HABIT_NAME, name);
        values.put(HABIT_NOTIFICATION, notification);
        values.put(HABIT_TIME, time);
        values.put(HABIT_DAY, day);
        long newRowId = db.insert( TABLE,null, values);
      if(newRowId != 1) return false;
      else return true;
    }

    ArrayList<Habit> GetDate(Context ctx){
       ArrayList<Habit> habit = new ArrayList<>();
        DatabaseHelper dbHelper = new DatabaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE, null);

// Проходим через все ряды

        try {
            while (cursor.moveToNext()) {
                Habit tmp = new Habit();
                // Используем индекс для получения строки или числа

                tmp.setName(cursor.getString(cursor.getColumnIndex(HABIT_NAME)));
                tmp.setNotificationText(cursor.getString(cursor.getColumnIndex(HABIT_NOTIFICATION)));
                tmp.setNotificationTime(cursor.getInt(cursor.getColumnIndex(HABIT_TIME)));
                tmp.setDay(cursor.getInt(cursor.getColumnIndex(HABIT_DAY)));
                habit.add(tmp);

            }
        } finally {
            cursor.close();
        }
        return habit;
    }

}

package com.example.kurs2_0;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

/*public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "habits.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "habit"; // название таблицы в бд

    // названия столбцов
    public static final String HABIT_ID = "_id";
    public static final String HABIT_NAME = "name";
    public static final String HABIT_NOTIFICATION = "notification";
    public static final String HABIT_TIME = "time";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" + HABIT_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + HABIT_NAME
                + " TEXT, " + HABIT_NOTIFICATION + " INTEGER)"+"");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR  + ") VALUES ('Том Смит', 1981);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}*/

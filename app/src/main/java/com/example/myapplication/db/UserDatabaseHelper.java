package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDatabaseHelper {
    private DatabaseHelper dbHelper;

    public UserDatabaseHelper(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Регистрация пользователя
    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);

        long result = db.insert(DatabaseHelper.TABLE_USERS, null, values);
        db.close();
        return result != -1; // Если вставка прошла успешно
    }

    // Авторизация пользователя
    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS,
                null,
                DatabaseHelper.COLUMN_USERNAME + "=? AND " + DatabaseHelper.COLUMN_PASSWORD + "=?",
                new String[]{username, password},
                null, null, null);

        boolean isAuthenticated = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return isAuthenticated;
    }
}
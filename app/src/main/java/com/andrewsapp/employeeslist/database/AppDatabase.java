package com.andrewsapp.employeeslist.database;

import android.content.Context;

import com.andrewsapp.employeeslist.pojo.Employee;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase db = null;
    private static final String DB_NAME = "Employees.db";

    public static AppDatabase getInstance(final Context context) {
        if (db == null) {
            synchronized (AppDatabase.class) {
                if (db == null) {
                    db = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return db;
    }
    public abstract EmployeesInfoDao employeesInfoDao();
}

package com.example.navigation_scaffold.repository.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();

    private static AppDatabase db;

    public static AppDatabase getInstance(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context, AppDatabase.class, "db")
                    .allowMainThreadQueries()       // Main 스레드 사용 ok
                    .fallbackToDestructiveMigration()   // 스키마 변경 ok
                    .build();
        }
        return db;
    }
}

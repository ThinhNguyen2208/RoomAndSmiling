package com.example.demoroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = = 1)
public abstract class AppDatabase extends RoomDatabase  {



    public abstract UserDao userDao();

    private static  AppDatabase INSTANE;

    public static AppDatabase getDbInstance(Context context){
        if(INSTANE == null){
            INSTANE = Room.databaseBuilder(context.getApplicationContext() , AppDatabase.class
            ,"DB_NAME")
            .allowMainThreadQueries()
            .build();
                         }
        return INSTANE;


        }


}


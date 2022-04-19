package com.example.demoroom.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "First_name")
    public  String firstName;
    @ColumnInfo(name = "Last_name")
    public String lastName;
}

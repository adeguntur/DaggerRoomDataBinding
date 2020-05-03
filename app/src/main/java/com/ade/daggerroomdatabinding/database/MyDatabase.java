package com.ade.daggerroomdatabinding.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ade.daggerroomdatabinding.entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

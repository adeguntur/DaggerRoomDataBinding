package com.ade.daggerroomdatabinding.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.ade.daggerroomdatabinding.entity.User;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> all();

    @Insert
    void insert(User... users);
}

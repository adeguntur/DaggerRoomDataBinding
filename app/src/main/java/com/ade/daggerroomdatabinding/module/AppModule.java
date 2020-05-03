package com.ade.daggerroomdatabinding.module;

import android.content.Context;

import androidx.room.Room;

import com.ade.daggerroomdatabinding.database.MyDatabase;
import com.ade.daggerroomdatabinding.database.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton @Provides
    public MyDatabase provideMyDatabase(Context context){
        return Room.databaseBuilder(context, MyDatabase.class, "my-db").build();
    }

    @Singleton @Provides
    public UserDao provideUserDao(MyDatabase myDatabase){
        return myDatabase.userDao();
    }
}


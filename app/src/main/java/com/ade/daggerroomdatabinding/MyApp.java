package com.ade.daggerroomdatabinding;

import android.app.Application;

import com.ade.daggerroomdatabinding.component.AppComponent;
import com.ade.daggerroomdatabinding.component.DaggerAppComponent;
import com.ade.daggerroomdatabinding.module.AppModule;


public class MyApp extends Application {
    private static MyApp app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext())).build();
    }

    public static MyApp app(){
        return app;
    }

    public AppComponent appComponent(){
        return appComponent;
    }
}

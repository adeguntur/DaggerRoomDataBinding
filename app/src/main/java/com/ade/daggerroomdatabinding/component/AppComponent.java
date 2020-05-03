package com.ade.daggerroomdatabinding.component;

import com.ade.daggerroomdatabinding.module.AppModule;
import com.ade.daggerroomdatabinding.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}

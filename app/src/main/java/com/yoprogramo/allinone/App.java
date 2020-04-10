package com.yoprogramo.allinone;

import android.app.Application;

import com.yoprogramo.allinone.di.ApplicationComponent;
import com.yoprogramo.allinone.di.ApplicationModule;
import com.yoprogramo.allinone.di.DaggerApplicationComponent;

import timber.log.Timber;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}

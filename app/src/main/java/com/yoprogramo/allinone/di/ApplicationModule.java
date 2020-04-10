package com.yoprogramo.allinone.di;

import android.app.Application;
import android.content.Context;

import com.yoprogramo.allinone.login.di.LoginModule;
import com.yoprogramo.allinone.networkservices.di.APIModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {LoginModule.class, APIModule.class})
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}

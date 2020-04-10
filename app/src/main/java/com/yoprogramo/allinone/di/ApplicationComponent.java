package com.yoprogramo.allinone.di;

import com.yoprogramo.allinone.login.view.LoginActivity;
import com.yoprogramo.allinone.login.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(LoginActivity target);
    void inject(MainActivity target);
}

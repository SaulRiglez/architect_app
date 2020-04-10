package com.yoprogramo.allinone.login.di;

import com.yoprogramo.allinone.login.LoginActivityMVP;
import com.yoprogramo.allinone.login.model.ModelImpl;
import com.yoprogramo.allinone.login.presenter.PresenterImpl;
import com.yoprogramo.allinone.login.repository.LoginRepository;
import com.yoprogramo.allinone.login.repository.LoginRepositoryImpl;
import com.yoprogramo.allinone.login.repository.MemoryRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    @Singleton
    LoginActivityMVP.Presenter providesLoginPresenter(LoginActivityMVP.Model model) {
        return new PresenterImpl(model);
    }

    @Provides
    public LoginActivityMVP.Model providesLoginModel(LoginRepositoryImpl loginRepository) {
        return new ModelImpl(loginRepository);
    }

    @Provides
    public LoginRepository providesLoginRepository(MemoryRepository memoryRepository) {
        return new LoginRepositoryImpl(memoryRepository);
    }

    @Provides
    public MemoryRepository providesMemoryRepository() {
        return new MemoryRepository();
    }
}

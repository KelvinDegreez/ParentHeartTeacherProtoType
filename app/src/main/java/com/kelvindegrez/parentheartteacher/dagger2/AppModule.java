package com.kelvindegrez.parentheartteacher.dagger2;

import com.kelvindegrez.parentheartteacher.impl.Splash.SplashScreenModel;
import com.kelvindegrez.parentheartteacher.impl.Splash.SplashScreenPresenter;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    MainApp mApplication;

    public AppModule(MainApp application) {
        mApplication = application;
    }

    @Provides @Singleton
    MainApp providesApplication() {
        return mApplication;
    }

    //===== SPLASH
    @Provides @Singleton
    SplashPresenter providesSplashPresenter() {
        return new SplashScreenPresenter();
    }

    @Provides @Singleton
    SplashModel providesSplashModel() {
        return new SplashScreenModel();
    }

}
package com.kelvindegrez.parentheartteacher.dagger2;

import com.kelvindegrez.parentheartteacher.impl.home.HomeScreenModel;
import com.kelvindegrez.parentheartteacher.impl.home.HomeScreenPresenter;
import com.kelvindegrez.parentheartteacher.impl.splash.SplashScreenModel;
import com.kelvindegrez.parentheartteacher.impl.splash.SplashScreenPresenter;
import com.kelvindegrez.parentheartteacher.mvp.home.HomeModel;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashPresenter;

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

    //===== Home
    @Provides @Singleton
    HomePresenter providesHomePresenter() {
        return new HomeScreenPresenter();
    }

    @Provides @Singleton
    HomeModel providesHomeModel() {
        return new HomeScreenModel();
    }

}
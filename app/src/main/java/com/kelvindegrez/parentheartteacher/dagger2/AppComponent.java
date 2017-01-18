package com.kelvindegrez.parentheartteacher.dagger2;

import com.kelvindegrez.parentheartteacher.mvp.home.HomeModel;
import com.kelvindegrez.parentheartteacher.mvp.home.HomePresenter;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class})
public interface AppComponent {

    MainApp provideApplication();

    //==== SPLASH
    SplashPresenter provideSplashPresenter();
    SplashModel provideSplashModel();

    //==== Home
    HomePresenter provideHomePresenter();
    HomeModel provideHomeModel();

}

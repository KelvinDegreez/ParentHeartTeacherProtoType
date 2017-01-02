package com.kelvindegrez.parentheartteacher.dagger2;

import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashModel;
import com.kelvindegrez.parentheartteacher.mvp.Splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { AppModule.class})
public interface AppComponent {

    MainApp provideApplication();

    //==== SPLASH
    SplashPresenter provideSplashPresenter();
    SplashModel provideSplashModel();

}
